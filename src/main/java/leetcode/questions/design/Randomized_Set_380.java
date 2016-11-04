package leetcode.questions.design;

import java.util.*;

/**

 Design a data structure that supports all following operations in average O(1) time.

 1.	insert(val): Inserts an item val to the set if not already present.
 2.	remove(val): Removes an item val from the set if present.
 3.	getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.

 Example:
 // Init an empty set.
 RandomizedSet randomSet = new RandomizedSet();

 // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 randomSet.insert(1);

 // Returns false as 2 does not exist in the set.
 randomSet.remove(2);

 // Inserts 2 to the set, returns true. Set now contains [1,2].
 randomSet.insert(2);

 // getRandom should return either 1 or 2 randomly.
 randomSet.getRandom();

 // Removes 1 from the set, returns true. Set now contains [2].
 randomSet.remove(1);

 // 2 was already in the set, so return false.
 randomSet.insert(2);

 // Since 1 is the only number in the set, getRandom always return 1.
 randomSet.getRandom();

 Simple array holder with map lookup

 */
public class Randomized_Set_380 {

    private final Map<Integer, Integer> lookup;
    private final List<Integer> holder;
    private final Random random;

    /** Initialize your data structure here. */
    public Randomized_Set_380() {
        this.lookup = new HashMap<>();
        this.holder = new ArrayList<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist = this.lookup.containsKey(val);

        if (!exist) {
            this.holder.add(val);
            this.lookup.put(val, this.holder.size() - 1);
        }

        return !exist;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean exist = this.lookup.containsKey(val);

        if (exist) {
            int index = this.lookup.get(val);
            int lastIndex = this.holder.size() - 1;

            if (index == lastIndex) {
                // either only 1 element or the element is the last one
                this.holder.remove(index);
            }
            else {
                // swap last element with this element and remove the last, O(1) remove
                int last = this.holder.get(lastIndex);
                this.holder.set(index, last);
                this.holder.remove(lastIndex);
                this.lookup.put(last, index);
            }

            this.lookup.remove(val);
        }

        return exist;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (this.holder.size() == 0) {
            throw new IllegalStateException("Collection empty");
        }
        int index = this.random.nextInt(this.holder.size());
        return this.holder.get(index);
    }

}
