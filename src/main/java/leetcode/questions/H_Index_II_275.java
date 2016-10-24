package leetcode.questions;

/**
 Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

 ------------------------------------------------------------------------------------------------------

 The advantage is that I don't need to increment all the ones below in my h-index...just some dp like to use the previous
 (upper) and add it to the current when I scan for max h-index

 */
public class H_Index_II_275 {

    public int hIndex(int[] citations) {
        if ((citations == null) || (citations.length == 0)) {
            return 0;
        }

        // no need to do more than # of publications
        int[] h = new int[citations[citations.length - 1] + 1];

        for (int citation : citations) {
            h[citation]++;
        }

        Integer previous = null;
        for (int number = citations[citations.length - 1]; number > 0; number--) {
            int publication = h[number];
            if (previous != null) {
                publication += previous.intValue();
            }
            if (number <= publication) {
                return number;
            }
            previous = publication;
        }

        return 0;
    }

}
