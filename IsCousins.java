/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        return isCousins(root, x, y, 0) >= 0;    
    }
    
    private int isCousins(TreeNode root, int x, int y, int level) {
        if (root == null) return -1;
        if (root.val == x || root.val == y) {
            int left = isCousins(root.left, x, y, level + 1); 
            int right = isCousins(root.right, x, y, level + 1);
            if (left > 0 || right > 0) return -1;
            return level;
        }
        int left = isCousins(root.left, x, y, level + 1);
        int right = isCousins(root.right, x, y, level + 1);
        System.out.println(left);
        System.out.println(right);
        if (right == left && right > 0){
            if ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)) {
                return -1;
            } else {
                return right;
            }
        } else if (left > 0 && right < 0 || right > 0 && left < 0) {
            return Math.max(left, right);
        } else {
            return -1;
        }
    }
}
