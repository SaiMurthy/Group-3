import java.util.*;

/**
 * @author Group 3 - Exceptions: Ashley Mead, Masa Nakura-Fan, Sai Murthy, Soleil Xie
 */
class OpenTheLock {
    
    /**
     * Time Complexity: O(V + E)
     * Space Complexity: O(V)
     * Based on a starting combination of "0000", calculating the opening of a lock by turning the wheels to a given combination
     * @param deadends If the lock displays any of these combinations, it will be stuck and no longer open
     * @param target The combination of the wheels that will unlock the lock
     * @return Minimum total number of turns required to open the lock (reach the target combination), or -1 if not possible
     */
    public int openLock(String[] deadends, String target) {
        Set<String> s = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            s.add(deadends[i]);
        }
        // returns -1 if starting or target value is a deadend
        if (s.contains("0000") || s.contains(target)) return -1;
        // return 0 if starting value is target
        if (target.equals("0000")) return 0;
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.add("0000");
        // BFS loop, every cycle is the next step in turning the lock
        while(!q.isEmpty()) {
            step++;
            int size = q.size();
            // the current step consists of the initial size of the enqueued permutaion
            for (int j = 0; j < size; j++) {
                String temp = q.remove();
                Set<String> combo = getNeighbors(temp);
                // check if each permutation is the target or is not already visited/deadend
                for (String permu: combo) {
                    if (permu.equals(target)) {
                        return step;
                    }
                    if (!s.contains(permu)) {
                        System.out.println(permu);
                        s.add(permu);
                        q.add(permu);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Find the "neighbors": possible combinations from turning each wheel once each way from the current combination
     * @param cur the current combination
     * @return a set of the "neighbors"
     */
    public Set<String> getNeighbors(String cur) {
        Set<String> results = new HashSet<String>();
        String curStr = "";
        // Separate the string into individual numbers so they can be "turned" individually
        char[] charArr = cur.toCharArray();
        
        // For every "wheel," or number in the lock
        for(int i = 0; i < 4; i++) {
            // reset the character array to the original combination before finding other combinations
            charArr = cur.toCharArray();
            // The "neighbors" for each value are the values one less and one more, as indicated by adding j, which loops between -1 and 2
            for(int j = -1; j <= 2; j += 3) {
                char curChar = (char)((int) (charArr[i] - '0' + j + 10) % 10 + '0');
                // replace the current of the 4 values in the combination with the subsequent character determined in the previous line
                charArr[i] = curChar;
                curStr = String.valueOf(charArr); 
                results.add(curStr);
            }
        }
        return results;
    }
}