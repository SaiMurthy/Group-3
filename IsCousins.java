// Exceptions - Group 3
// Done by - Masa Nakura-Fan, Ashley Mead, Sai Murthy, Soleil Xie
class Solution {
    // returns true if the nodes containing values x and y have the same height but not the same parent
    // int the given tree. returns false otherwise
    public boolean isCousins(TreeNode root, int x, int y) {
        return isCousins(root, x, y, 0) >= 0;    
    }
    
    // returns an integer representing the height of the nodes containing the given x or y found in the given tree
    // If the two nodes are not found or the parent of the are the same, returns -1. 
    // @param root - given tree that is searched through
    // @param level - the height of the current root
    private int isCousins(TreeNode root, int x, int y, int level) {
        if (root == null) return -1;
        int left = isCousins(root.left, x, y, level + 1);
        int right = isCousins(root.right, x, y, level + 1);
        if (root.val == x || root.val == y) {
            if (left > 0 || right > 0) return -1;
            return level;
        }
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
