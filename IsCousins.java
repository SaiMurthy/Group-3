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
        if (root.val == x || root.val == y) { // if current node contains val x or y
            if (left > 0 || right > 0) return -1; // returns -1 if a subtree of this root contains the other value because then, it cannot have the same height
            return level; // returns the height of the node
        }
        if (right == left && right > 0){ // if right height is equal to left height and both heights are greater than 0
            if ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x)) { // if the two nodes containing x and y do not have same parents
                return -1;
            } else { // else, returns their height
                return right;
            }
        } else if (left > 0 && right < 0 || right > 0 && left < 0) { 
            // keeps returning the value found if one is greater than zero and the other is less than zero. 
            // this is because when this happens, either the heighs of two nodes have not been compared yet or already finished comparing
            return Math.max(left, right);
        } else {
            // returns -1 when both left and right heights are negative
            return -1;
        }
    }
}
