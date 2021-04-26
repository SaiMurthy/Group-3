package Ashley_HW;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

public class HeapPractice {
    
    public boolean isConsecutive(PriorityQueue<Integer> nums) {
        // Time Complexity: O(nlogn)
        // Space Complexity: O(n)
        if(nums == null || nums.size() <= 1) {
            return true;
        }

        boolean isConsecutive = true;
        Queue<Integer> temp = new LinkedList<>();
        Integer curr = nums.remove();
        temp.offer(curr);
        // check whether all the nums in the PriorityQueue are consecutive
        while(!nums.isEmpty()) {
            Integer next = nums.remove();
            if(curr + 1 != next) {
                isConsecutive = false;
            }
            temp.offer(next);
            curr = next;
        }

        // retore the original PriorityQueue
        while(!temp.isEmpty()) {
            nums.add(temp.poll());
        }

        return isConsecutive;
    }

    public void removeDuplicates(PriorityQueue<Integer> nums) {
        // Time Complexity: O(nlogn)
        // Space Complexity: O(n)
        if(nums == null || nums.size() <= 1) {
            return;
        }
        
        Queue<Integer> temp = new LinkedList<>();
        int prev = nums.remove();
        temp.add(prev);
        while(!nums.isEmpty()) {
            int curr = nums.remove();
            // Only add the current number if it is not a duplicate of the previous one
            if(curr != prev) {
                temp.add(curr);
            }
            prev = curr;
        }
        
        // retore the original PriorityQueue
        while(!temp.isEmpty()) {
            nums.add(temp.remove());
        }
    }

    public void stutter(PriorityQueue<Integer> nums) {
        // Time Complexity: O(nlogn)
        // Space Complexity: O(n)
        if(nums == null) {
            return;
        }
        
        Queue<Integer> temp = new LinkedList<>();
        while(!nums.isEmpty()) {
            int curr = nums.remove();
            // add the current value twice
            temp.add(curr);
            temp.add(curr);
        }
        
        // retore the original PriorityQueue
        while(!temp.isEmpty()) {
            nums.add(temp.remove());
        }
    }

    public void fillGaps(PriorityQueue<Integer> nums) {
        // Time Complexity: O(nlogn)
        // Space Complexity: O(n)
        if(nums == null || nums.size() <= 1) {
            return;
        }
        
        Queue<Integer> temp = new LinkedList<>();
        
        int prev = nums.remove();
        int curr = nums.remove();
        temp.add(prev);
        while(!nums.isEmpty()) {
            curr = nums.remove();
            // Filling gaps:
            // If there are values between the previous and current numbers,
            // start at one more than the previous number and add the consecutive values to the queue
            // until the number at the current index is reached
            if(prev != curr && prev != curr - 1) {
                int count = prev + 1;
                while(count != curr) {
                    temp.add(count);
                    count++;
                }
            }
            temp.add(curr);
            prev = curr;
        }

        // retore the original PriorityQueue
        while(!temp.isEmpty()) {
            nums.add(temp.remove());
        }
    }
}
