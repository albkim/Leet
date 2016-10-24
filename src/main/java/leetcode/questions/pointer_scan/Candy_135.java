package leetcode.questions.pointer_scan;

import java.util.*;

/**
 There are N children standing in a line. Each child is assigned a rating value.

 You are giving candies to these children subjected to the following requirements:
 �Each child must have at least one candy.
 �Children with a higher rating get more candies than their neighbors.

 What is the minimum candies you must give?


 ---------------------------------------------------------------------------------------------------

 Completely misunderstood the question...i cannot rearrange children, can just decide where the min is

 Seems like we need to find local minima and do the logic of either putting 1 (if neighbor is same)
 or bump it by 1

 I think we need to identify local minima and maxima. For each local minima, we need to then traverse left right. Based
 on whether it's same or greater we can bump up by 1 or stay same. Once we hit local maxima, we need to take max from
 either side.

 */
public class Candy_135 {

    public static int candy(int[] ratings) {
        if ((ratings == null) || (ratings.length == 0)) {
            return 0;
        }

        // some base conditions
        if (ratings.length == 1) {
            return 1;
        }
        else if (ratings.length == 2) {
            if (ratings[0] == ratings[1]) {
                return 2;
            }
            return 3;
        }

        int previous = ratings[0];
        Boolean increasing = null;
        Set<Integer> maximas = new HashSet<>();
        Set<Integer> minimas = new HashSet<>();
        for (int index = 1; index < ratings.length; index++){
            // find inflection point
            if (previous == ratings[index]) {
            }
            else if (previous < ratings[index]) {
                if ((increasing != null) && (!increasing.booleanValue())) {
                    // find the change in direction, we were going down before and we just went up
                    minimas.add(index - 1);
                }
                increasing = true;
            }
            else {
                if ((increasing != null) && (increasing.booleanValue())) {
                    // we were going up and we just went down
                    maximas.add(index - 1);
                }
                increasing = false;
            }

            previous = ratings[index];
        }

        // take care of two ends
        if (ratings[0] < ratings[1]) {
            minimas.add(0);
        }
        if (ratings[ratings.length - 2] > ratings[ratings.length - 1]) {
            minimas.add(ratings.length - 1);
        }

        // edge condition...all same ratings
        if (minimas.size() == 0) {
            return ratings.length;
        }

        int[] candies = new int[ratings.length];
        for (int minima : minimas) {
            candies[minima] = 1;
            for (int direction = -1; direction <= 1; direction += 2) {
                int number = 1;
                int index = minima + direction;
                while (true) {
                    if ((index < 0) || (index >= ratings.length)) {
                        // we don't need to go further
                        break;
                    }
                    if (minimas.contains(index)) {
                        // we hit another minima which could be on the same bottom, don't need to go further
                        break;
                    }
                    if (ratings[index] == ratings[index - direction]) {
                        // reset to 1 if this is same number
                        number = 1;
                    }
                    else if (ratings[index] > ratings[index - direction]) {
                        // if rating is bigger than previous, we need to bump up by 1
                        number++;
                    }
                    if (maximas.contains(index)) {
                        candies[index] = Math.max(candies[index], number);
                        break;
                    }
                    candies[index] = number;
                    index += direction;
                }
            }
        }

        int total = 0;
        for (int candy : candies) {
            total += candy;
        }
        return total;
    }

}
