package 阅文;

import java.util.*;

public class Solution {
    static Queue<Integer> queue;
    static Map<Integer, Integer> map;
    static int cap;

 public Solution(int capacity) {
    // write code here
    queue = new LinkedList<>();
    map = new HashMap<>();
    cap=capacity;
 }

    public int get(int key) {
        // write code here
        if (!map.containsKey(key)) {
            return -1;
        }
        queue.remove(key);
        queue.add(key);
        return map.get(key);
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            queue.remove(key);
            queue.add(key);
            map.put(key, value);
        } else {
            queue.add(key);
            map.put(key, value);
        }
        if(queue.size()>cap){
            int removeKey=queue.poll();
            map.remove(removeKey);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution solution = new Solution(capacity);
 * int output = solution.get(key);
 * solution.set(key,value);
 */