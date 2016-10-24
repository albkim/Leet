package leetcode.questions;

import java.util.Arrays;
import java.util.Random;

/**
 // Init an array with set 1, 2, and 3.
 int[] nums = {1,2,3};
 Solution solution = new Solution(nums);

 // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 solution.shuffle();

 // Resets the array back to its original configuration [1,2,3].
 solution.reset();

 // Returns the random shuffling of array [1,2,3].
 solution.shuffle();



 -----------------------------------------------------------------------------------------------


 Reservoir sampling doesn't work since reservoir size == entire size,
 but I can see a twist where they want to get a smaller sample

 Sampling without replacement - time: O(n), space: 2n
 */
public class Shuffle_Array_384 {

    private final Random r;
    private final int[] numbers;
    private final int[] originalNumbers;

    public Shuffle_Array_384(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers null");
        }

        this.r = new Random();
        this.numbers = numbers;

        // don't make a mistake of just setting this to numbers, since it's a reference
        this.originalNumbers = Arrays.copyOf(this.numbers, this.numbers.length);
    }

    public int[] shuffle() {
        for (int offset = 0; offset < this.numbers.length; offset++) {
            // bound is exclusive and 0 is inclusive
            // so when offset is 0, this will produce a random index from 0 - (length - 1)
            // as offset increase, it will move the bound towards the right of the array
            int randomIndex = this.r.nextInt(this.numbers.length - offset) + offset;

            // now swap the picked number with the current offset
            int current = this.numbers[offset];
            this.numbers[offset] = this.numbers[randomIndex];
            this.numbers[randomIndex] = current;
        }

        return this.numbers;
    }

    public int[] reset() {
        // don't try to array copy here since it will reinitialize final numbers
        // do a manual copy
        for (int index = 0; index < this.originalNumbers.length; index++) {
            this.numbers[index] = this.originalNumbers[index];
        }

        return this.numbers;
    }

}
