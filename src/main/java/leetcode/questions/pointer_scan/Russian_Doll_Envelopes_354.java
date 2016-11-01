package leetcode.questions.pointer_scan;

/**
 You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 One envelope can fit into another if and only if both the width and height of one envelope
 is greater than the width and height of the other envelope.

 What is the maximum number of envelopes can you Russian doll? (put one inside other)
 Example: Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes
 you can Russian doll is 3([2,3] => [5,4] => [6,7]).


 ------------------------------------------------------------------------------------------------


 This is a twist in longest increasing subsequence

 1, 3, 4, 2, 6, 7

 1
 1, 3 -> 1, 2
 1, 3, 4
 1, 3, 4, 6
 1, 3, 4, 6, 7

 It's very simple, do a sort by width asc and height desc (if width are the same). Take all heights as a 1D array
 Do LIS.

 */
public class Russian_Doll_Envelopes_354 {

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        sort(envelopes, 0, envelopes.length - 1);

        int[] heights = new int[envelopes.length];
        for (int index = 0; index < envelopes.length; index++) {
            heights[index] = envelopes[index][1];
        }

        // Simple LIS here now
        int[] lis = new int[heights.length];
        Integer currentBoundary = null;
        for (int index = 0; index < heights.length; index++) {
            // see if it goes at the boundary or binary search into replace position
            if (currentBoundary == null) {
                lis[0] = heights[index];
                currentBoundary = 0;
            }
            else {
                if (lis[currentBoundary.intValue()] < heights[index]) {
                    // easy...extend
                    currentBoundary++;
                    lis[currentBoundary] = heights[index];
                }
                else {
                    // binary search the next bigger one
                    int start = 0;
                    int end = currentBoundary;

                    int smallest = lis[currentBoundary];
                    int smallestIndex = currentBoundary;
                    while (start <= end) {
                        int mid = start + ((end - start) >> 1);
                        if (lis[mid] == heights[index]) {
                            // same. we can discard this
                            smallestIndex = mid;
                            break;
                        }
                        else if (lis[mid] < heights[index]) {
                            // move right
                            start = mid + 1;
                        }
                        else {
                            if (smallest > lis[mid]) {
                                smallest = lis[mid];
                                smallestIndex = mid;
                            }
                            end = mid - 1;
                        }
                    }
                    lis[smallestIndex] = heights[index];
                }
            }
        }

        return currentBoundary + 1;
    }

    private static void sort(int[][] envelopes, int left, int right) {
        // take first as a pivot
        int[] pivot = envelopes[left];
        int start = left + 1;
        int end = right;

        // smaller or equal on the left, larger on the right
        while(start <= end) {
            if (compare(envelopes[start], pivot) <= 0) {
                start++;
            }
            else {
                swap(envelopes, start, end);
                end--;
            }
        }

        int pivotIndex = Math.min(start, end);

        // swap pivot with current left
        swap(envelopes, left, pivotIndex);

        if (pivotIndex - left > 1) {
            sort(envelopes, left, pivotIndex - 1);
        }
        if (right - pivotIndex > 1) {
            sort(envelopes, pivotIndex + 1, right);
        }
    }

    private static void swap(int[][] envelopes, int left, int right) {
        int[] temp = envelopes[left];
        envelopes[left] = envelopes[right];
        envelopes[right] = temp;
    }

    private static int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
            if (o1[1] == o2[1]) {
                return 0;
            }

            // desc
            return o1[1] < o2[1] ? 1 : -1;
        }

        // asc
        return o1[0] < o2[0] ? -1 : 1;
    }

}
