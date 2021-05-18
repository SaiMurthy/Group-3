
/**
 * @author Group 3
 */
class KthSmallestElement {
    /**
     * Time Complexity: O(k*logk)
     * Space Complexity: O(k)
     * 
     * @param matrix an nxn matrix
     * @param k an integer
     * @return the kth smallest element in the given matrix
     */

    public int kthSmallest(int[][] matrix, int k) {
        boolean[][] visited = new boolean[matrix.length][matrix.length];
        PriorityQueue<Num> pq = new PriorityQueue<Num>();
        int step = 0; 
        pq.add(new Num(matrix[0][0], 0, 0));
        visited[0][0] = true;
        // best first search
        while (!pq.isEmpty()) {
            step++;
            Num temp = pq.remove();
            // returns the element when found the kth smallest number
            if (step == k) {
                return temp.n;
            }
            // get the row next to the current element
            int tempR = temp.r + 1;
            // get the column next to the current element
            int tempC = temp.c + 1;
            // expands to the next element in row (bottom) and marks as visited
            if (tempR < matrix.length && !visited[tempR][temp.c]) {
               pq.add(new Num(matrix[tempR][temp.c], tempR, temp.c)); 
               visited[tempR][temp.c] = true;
            }
            // expands to the next element in column (right) and marks as visited
            if (tempC < matrix.length && !visited[temp.r][tempC]) {
                pq.add(new Num(matrix[temp.r][tempC], temp.r, tempC)); 
                visited[temp.r][tempC] = true;
            }
        }
        return -1;
    }

    // stores the element 
    public static class Num implements Comparable<Num> {
        // number, row, column
        int n, r, c;
        public Num(int a, int b, int d) {
            n = a;
            r = b;
            c = d;
        }
        // will be sorted so that the element will be in ascending order. 
        public int compareTo(Num nu) {
            return Integer.compare(this.n, nu.n);
        }
    }
}