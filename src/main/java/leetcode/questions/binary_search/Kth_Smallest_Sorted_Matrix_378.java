package leetcode.questions.binary_search;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**

 Kth Smallest Element in a Sorted Matrix

 Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

 Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 Example:

 matrix = [
 [ 1,  5,  9],
 [10, 11, 13],
 [12, 13, 15]
 ],
 k = 8,

 return 13.

 ---------------------------------------------------------------------------------------------------------------


 Interesting, it's only sorted within a row or within a column

 One option is to use merge sorting multiple sorted arrays, using something like a priority queue and keep popping an row until we get to k

 One option seems like we can do binary search and count
 Once we pick a number, start from bottom left and move right until the number is bigger than the number chosen,
 count is all the number above in the given column. Once a bigger number is found, move up to a previous row, and continue
 to move right (since within a column, the number above is supposed to be less than the current
 */
public class Kth_Smallest_Sorted_Matrix_378 {

    private static class SearchResult {
        public int largest;
        public int count;
    }

    private static class ArrayWrapper {
        public int[] a;
        public int offset;

        public ArrayWrapper(int[] a, int offset) {
            this.a = a;
            this.offset = offset;
        }
    }

    // O((n + k) log n)
    public static int kthSmallestPriorityQueue(int[][] matrix, int k) {
        // need a min heap of all array ref where comparison happens at the current head index
        // we will use array wrapper to keep an offset which can work this way
        Queue<ArrayWrapper> queue = new PriorityQueue<>(new Comparator<ArrayWrapper>() {
            @Override
            public int compare(ArrayWrapper o1, ArrayWrapper o2) {
                if (o1.a[o1.offset] == o2.a[o2.offset]) {
                    return 0;
                }
                // ascending order
                return o1.a[o1.offset] < o2.a[o2.offset] ? -1 : 1;
            }
        });

        for (int[] a : matrix) {
            queue.add(new ArrayWrapper(a, 0));
        }

        // now the root is array wrapper with the lowest value. This is the 1st item in merged array
        int kCount = 1;
        while (kCount < k) {
            // start popping off from the lowest value
            ArrayWrapper aw = queue.poll();
            if (aw != null) {
                // we could have exhausted one of the arrays, so we should do this check
                if (aw.offset < aw.a.length - 1) {
                    aw.offset++;

                    // there are some items, in this array, add it back, this also ensures the priority queue
                    // is resorted with the new head of this array
                    queue.add(aw);
                }
            }
            kCount++;
        }

        // now we popped off still k-1, the current lowest would be kth element
        ArrayWrapper aw = queue.peek();
        if (aw != null) {
            return aw.a[aw.offset];
        }

        // something wrong like n^2 < k
        throw new IllegalArgumentException();
    }

    // O(2n log n^2)
    public static int kthSmallestBinarySearch(int[][] matrix, int k) {
        int smallest = matrix[0][0];
        int largest = matrix[matrix.length - 1][matrix.length - 1];
        SearchResult result = null;
        SearchResult previousHigh = null;
        while (smallest <= largest) {
            int mean = smallest + ((largest - smallest) >> 1); // should be same as /2 since << is *2
            result = search(matrix, mean);
            if (result.count == k) {
                // lucky scenario where we converged on k
                // this my not be the case if there are dupes. i.e. k = 5 and there are 3 x 8's from 4-6
                return result.largest;
            }
            else if (result.count < k) {
                smallest = mean + 1;
            }
            else {
                // move left
                largest = mean - 1;
                if (previousHigh == null) {
                    previousHigh = result;
                }
                else if (previousHigh.count > result.count) {
                    previousHigh = result;
                }
            }
        }

        // if we converged on high value, the answer is easy. it's the kth number just that there are dupes
        if ((result != null) && (result.count > k)) {
            return result.largest;
        }
        // if we converged on lower value, we need to use the previous high value since with dupes, it could
        // converge on either
        else if (previousHigh != null) {
            return previousHigh.largest;
        }

        // something wrong like n^2 < k
        throw new IllegalArgumentException();
    }

    // O(2n)
    private static SearchResult search(int[][] matrix, int target) {
        int y = matrix.length - 1;
        int x = 0;

        SearchResult result = new SearchResult();

        while ((y >= 0) && (x < matrix.length)) {
            // if current value is greater than target, then no point going right (guarantee to be larger)
            // so move up and check
            if (matrix[y][x] > target) {
                y--;
                continue;
            }

            // as long as current value is smaller or equal, count and move right
            if (result.largest < matrix[y][x]) {
                result.largest = matrix[y][x];
            }

            // the counting is funny, as we move right, anything above is guarantee to be less, so we don't need to count
            // up...instead just add y index + 1
            result.count += y + 1;
            x++;
        }

        return result;
    }

}
