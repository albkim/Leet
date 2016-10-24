package leetcode.questions.array;

/**
 There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
 You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.

------------------------------------------------------------------------------------------------------------------

 Seems like I can try each gas station as a starting point and backtrack if I run out of gas

 yeah that's not fast enough...maybe we can do something smart if we know left over gas for each station to next
 As we get the running sum, we can try next possible position of gas station where we run out

 Think about it this way, if we start from 1 and run out of gas at 7..there is no way starting from 1-7 will get you pass
 7 (any number before 7 combined contributed positively overall). So best options is to start from 8 and see if we
 can build up enough gas to get past 7 when we come around. The tricky bit is that once we wrap around and stop...we need to
 return -1

 */
public class Gas_Station_134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if ((gas == null) || (gas.length == 0)) {
            return -1;
        }

        /*
        for (int index = 0; index < gas.length; index++) {
            if (backtrack(index, gas, cost, 0, 0, gas.length)) {
                return index;
            }
        }
        */

        int possibleStart = 0;
        boolean looped = false;
        while (possibleStart < gas.length) {
            int runningSum = 0;
            int visited = 0;
            int index = possibleStart;
            while (visited < gas.length) {
                runningSum += gas[index] - cost[index];
                if (runningSum < 0) {
                    if (!looped) {
                        // no point, need to try after this or before this which is same thing
                        possibleStart = index + 1;
                        break;
                    }
                    return -1;
                }
                visited++;
                index++;

                if (index == gas.length) {
                    index = 0;
                    looped = true;
                }
                if (visited == gas.length) {
                    return possibleStart;
                }
            }
        }

        return -1;
    }

    private static boolean backtrack(int current, int[] gas, int[] cost, int available, int visited, int target) {
        if (visited == target) {
            return true;
        }

        if (current >= target) {
            current = 0;
        }

        int left = available + gas[current] - cost[current];
        if (left >= 0) {
            return backtrack(current + 1, gas, cost, left, visited + 1, target);
        }

        return false;
    }

}
