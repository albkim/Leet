package leetcode.questions.design;

import java.util.*;

/**
 Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.

 ------------------------------------------------------------------------------------------------------------

 The trick is to use a map with a priority queue. When we need to flush, flush from the queue and then use that to
 evict. However since we don't plan to reorder the queue every time there is a get call, track the time on the map
 and use that to compare against the next element of the queue, if the order is not correct, reinsert this back and
 continue evicting

 */
public class LRU_Cache_146 {

    private class QueueWrapper {
        public int time;
        public int key;

        public QueueWrapper(int time, int key) {
            this.time = time;
            this.key = key;
        }

    }

    private class MapWrapper {
        public int time;
        public int value;
        public QueueWrapper queueWrapper;

        public MapWrapper(int time, int value, QueueWrapper queueWrapper) {
            this.time = time;
            this.value = value;
            this.queueWrapper = queueWrapper;
        }
    }

    private int timer;
    private int capacity;
    private Map<Integer, MapWrapper> map;
    private Queue<QueueWrapper> queue;

    public LRU_Cache_146(int capacity) {
        this.capacity = capacity;

        this.timer = 0;
        this.map = new HashMap<>();
        this.queue = new PriorityQueue<>(new Comparator<QueueWrapper>() {
            @Override
            public int compare(QueueWrapper o1, QueueWrapper o2) {
                return o1.time - o2.time;
            }
        });
    }

    public int get(int key) {
        if (this.map.containsKey(key)) {
            this.timer++;

            MapWrapper mapWrapper = this.map.get(key);
            mapWrapper.time = this.timer;
            mapWrapper.queueWrapper.time = this.timer;

            this.queue.remove(mapWrapper.queueWrapper);
            this.queue.add(mapWrapper.queueWrapper);

            return mapWrapper.value;
        }

        return -1;
    }

    public void set(int key, int value) {
        this.timer++;

        if (this.map.containsKey(key)) {
            MapWrapper mapWrapper = this.map.get(key);
            mapWrapper.time = this.timer;
            mapWrapper.value = value;
            mapWrapper.queueWrapper.time = this.timer;

            this.queue.remove(mapWrapper.queueWrapper);
            this.queue.add(mapWrapper.queueWrapper);
        }
        else {
            QueueWrapper queueWrapper = new QueueWrapper(this.timer, key);
            this.map.put(key, new MapWrapper(this.timer, value, queueWrapper));
            this.queue.add(queueWrapper);
        }

        if (this.queue.size() > this.capacity) {
            // just pop one off
            QueueWrapper tip = this.queue.poll();
            this.map.remove(tip.key);
        }
    }

}
