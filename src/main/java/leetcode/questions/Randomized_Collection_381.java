package leetcode.questions;

import java.util.*;

/**

 Design a data structure that supports all following operations in average O(1) time.
 Note: Duplicate elements are allowed.

 1.	insert(val): Inserts an item val to the collection.
 2.	remove(val): Removes an item val from the collection if present.
 3.	getRandom: Returns a random element from current collection of elements. The probability of each element being returned is linearly related to the number of same value the collection contains.

 Example:
 // Init an empty collection.
 RandomizedCollection collection = new RandomizedCollection();

 // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 collection.insert(1);

 // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 collection.insert(1);

 // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 collection.insert(2);

 // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 collection.getRandom();

 // Removes 1 from the collection, returns true. Collection now contains [1,2].
 collection.remove(1);

 // getRandom should return 1 and 2 both equally likely.
 collection.getRandom();


 ----------------------------------------------------------------------------------------------


 in order to do a random selection in O(1) with lineararity wrt duplicates, we need something like an array with dupes occupying an entry each
 in order to do O(1) insertion, you need something like a list
 in order to do O(1) removal, you need something like a map of list but this conflicts with random selection
 in order to do O(1) dupe check, you need something like a map of counts/list

 What if we have a list and a map of sets (for indexes). The removal can be handled via replacing the last element with
 the element to be removed
 */
public class Randomized_Collection_381 {

    private final Map<Integer, Set<Integer>> lookup;
    private final List<Integer> holder;
    private final Random random;

    /** Initialize your data structure here. */
    public Randomized_Collection_381() {
        this.lookup = new HashMap<>();
        this.holder = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        this.holder.add(val);
        Set<Integer> indexes = null;
        if (this.lookup.containsKey(val)) {
            indexes = this.lookup.get(val);
        }
        else {
            indexes = new HashSet<>();
            this.lookup.put(val, indexes);
        }
        indexes.add(this.holder.size() - 1);
        return indexes.size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean exists = this.lookup.containsKey(val);

        if (exists) {
            Set<Integer> indexes = this.lookup.get(val);
            int index = indexes.iterator().next();
            indexes.remove(index);

            // need to cleanup
            if (indexes.size() == 0) {
                this.lookup.remove(val);
            }

            // in order to do constant remove, we should move the last element to existing item
            // position instead of just removing the item which means we need to update all indexes
            // of all the numbers from that item's index

            int lastIndex = this.holder.size() - 1;
            if (index == lastIndex) {
                // if there is only 1 item, or the chosen happens to be the last one, we don't need to swap
                this.holder.remove(index);
            }
            else {
                // swap last item with this one
                int last = this.holder.get(lastIndex);
                this.holder.set(index, last);
                this.holder.remove(lastIndex);

                // update the last item index
                Set<Integer> lastIndexes = this.lookup.get(last);
                lastIndexes.remove(lastIndex);
                lastIndexes.add(index);
            }
        }

        return exists;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if (this.holder.size() == 0) {
            throw new IllegalStateException("Collection empty");
        }
        int index = this.random.nextInt(this.holder.size());
        return this.holder.get(index);
    }

}
