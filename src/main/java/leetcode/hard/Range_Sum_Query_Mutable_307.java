package leetcode.hard;

/**
 Given an integer array nums, find the sum of the elements between indices i and j (i ? j), inclusive.
 The update(i, val) function modifies nums by updating the element at index i to val.
 Example:

 Given nums = [1, 3, 5]

 sumRange(0, 2) -> 9
 update(1, 2)
 sumRange(0, 2) -> 8

 Note:

 1.The array is only modifiable by the update function.
 2.You may assume the number of calls to update and sumRange function is distributed evenly.

 --------------------------------------------------------------------------------------------------------

 Looks like the answer is binary indexed tree.

 We can think of it this way. In immutable array, we optimized by storing the running sum. If we were to make
 an update, we need to update all sums. Making update operation O(n) i.e.
    1, 3, 5 -> 1, 4, 9; update 2 to 5 -> 1, (6), (11)

 Now a way to make the update O(1) is to store the diff of the sums. Now we can easily update any one entry.
    1, 3, 5 -> 1, 4, 9 -> 1, +3, +5; update 2 to 5 -> 1, +5, +5

 In this way though lookup is still O(n). We can try to improve this by using a binary tree. Consider the following
 [ +5] [ +1] [+15] [+11] [+52] [+28] [ +0]
   1     2     3     4     5     6     7

               4
             [+32]
            /     \
          2         6
       [ +6]       [+80]
       /   \       /   \
      1     3     5     7
    [ +5] [+15] [+52] [ +0]

 Created by performing an in order traversal of the initial array. However root node combines the increment of
 left subtree (node 2 has increment of 1 & 2; node 4 has increment of 1 + 2 + 3 +4). Further more, current + right
 would give you the sum up to right (in bst, right child is above all left subtree + current). We can use the index
 of the array to order the tree.

 So algo for finding a sum of a give index is to add the number every time we move right and then add the current

 However this not makes the update non constant. We need to update the parent recursively. If we were to update 1 to +10
               4
           ->[+37]
            /     \
         2           6
      ->[+11]       [+80]
       /   \       /   \
      1     3     5     7
 ->[+10] [+15] [+52] [ +0]

 The last part is how we do this without creating a binary tree (using an array and index). The index in bits is:

           100
          [+37]
         /     \
     010         110
    [+11]       [+80]
    /   \       /   \
  001   011   101   111
 [+10] [+15] [+52] [ +0]

 Lookup - take index n -> remove set bit (last 1 bit)
    There is a good technique for removing set bit. Observe
        7(111) and 6(110) and 4(100) has same prefix before the set bit. But inverted (0's) after
        So we could AND index & (index - 1) and remove it

 Update - take index n -> move the last set bit until we hit a set bit
    Here observe what happens if we add 1 to last set bit
        5(101) + 001 = 6 (110)
 */
public class Range_Sum_Query_Mutable_307 {

    private int[] nums;
    private int[] sumDiff;

    public Range_Sum_Query_Mutable_307(int[] nums) {
        this.nums = nums;
        this.sumDiff = new int[nums.length + 1];
        for (int index = 0; index < nums.length; index++) {
            traverseRight(index + 1, nums[index]);
        }
    }

    public void update(int i, int val) {
        traverseRight(i + 1, val - this.nums[i]);
        this.nums[i] = val;
    }

    public int sumRange(int i, int j) {
        // we just need to traverse left from each index to get sum of each index until we hit the left most root
        int left = traverseLeft(i);
        int right = traverseLeft(j + 1);
        return right - left;
    }

    private void traverseRight(int index1Based, int diff) {
        // after we pass the root, it will go beyond the length of array by definition (2^n)
        while(index1Based < this.sumDiff.length) {
            this.sumDiff[index1Based] += diff;

            int shift = 0;
            while(((index1Based >> shift) & 1) != 1) {
                shift++;
            }

            index1Based += (1 << shift);
        }
    }

    private int traverseLeft(int index1Based) {
        int total = 0;
        while(index1Based > 0) {
            total += this.sumDiff[index1Based];
            index1Based &= (index1Based - 1);
        }
        return total;
    }

}
