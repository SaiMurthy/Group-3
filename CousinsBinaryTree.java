import javax.swing.tree.TreeNode;
//Group Name: Exceptions
//Group Number : 3
// Done by : Sai Murthy, Ashley Mead, Soleil Xie, Kevin Nakura Fan
public class CousinsBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
    
    /**
     * Determines whether the nodes x and y are cousins - have the same height and
     * different parent nodes
     * 
     * @param root root node of the given tree
     * @param x    a node in the tree
     * @param y    a node in the tree
     * @return Whether x and y are cousins
     */
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] locX = new int[2];
        int[] locY = new int[2];
        if (root.val == x || root.val == y) {
            return false;
        }
        helper(root, locX, x, 0);
        helper(root, locY, y, 0);
        return locX[0] != locY[0] && locX[1] == locY[1];
    }

    /**
     * Time Complexity: O()
     * Space Complexity: O(n)
     * Helper method for cousins - updates the height and parent node
     * 
     * @param root root of the given tree
     * @param valLoc location of the value; has value and height
     * @param val value of the node we are searching for
     * @param height height of the current node
     */
    public void helper(TreeNode root, int[] valLoc, int val, int height) {
        if (root == null) {
            return;
        }
        if ((root.left != null && root.left.val != null) || (root.right != null && root.right.val != null)) {
            valLoc[0] = root.val;
            valLoc[1] = height;
            return;
        }
        helper(root.left, valLoc, val, height + 1);
        helper(root.right, valLoc, val, height + 1);
    }
}