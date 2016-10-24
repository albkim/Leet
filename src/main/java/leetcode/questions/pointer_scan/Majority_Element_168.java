package leetcode.questions.pointer_scan;

/**
 Given an array of size n, find the majority element. The majority element is the element that appears more than ? n/2 ? times.

 You may assume that the array is non-empty and the majority element always exist in the array.

 -------------------------------------------------------------------------------------------------------

 Simple majority algo. As we scan, we add 1 if element is same as current majority, if we see a diff one, decrement by 1
 If we reach 0, replace the candidate

 Since it's guaranteed that a majority exists, we don't need to do the majority check (above does not guarantee a majority)
 */
public class Majority_Element_168 {

    public static int majorityElement(int[] nums) {
        if ((nums == null) || (nums.length == 0)) {
            return -1;
        }

        int candidate = -1;
        int candidateCount = 0;

        for (int num : nums) {
            if (candidateCount == 0) {
                candidate = num;
            }

            if (num == candidate) {
                candidateCount++;
            }
            else {
                candidateCount--;
            }
        }

        return candidate;
    }

}
