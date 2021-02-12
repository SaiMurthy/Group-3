// Group 3 - Exceptions
public class BinaryTreePractice {


    // Contributer: Kevin Masa Nakura-Fan
    // returns a node in the given tree containing the given value
    // @param root - a binary tree that is searched
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return root;
            }
            TreeNode right = searchBST(root.right, val);
            TreeNode left = searchBST(root.left, val);
            if (right != null) {
                return right;
            } else if (left != null) {
                return left;
            }
        }
        return null;
    }

    // Ashley Mead
    /**
     * returns the lowest common ancestor of nodes p and q
     * @param root - the binary search tree currently being searched
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        return left == null && right == null ? null : left != null && right != null ? root : left != null ? left : right != null ? right : root;
    }
    
    //Soleil Xie
    public int height() {
        //calls the height method with a parameter
        return height(overallRoot);
    }
    public int height(IntTreeNode root) {
        //base case: if the root doesn't exist, return 0
        if (root == null) {
                return 0;
        }
        //finds the maximum height on both right and left nodes
        return 1 + max(height(root.left), height(root.right));
    }
    public static int max(int a, int b) {
        if(a < b)
            return b;
        return a;
    }
    //Sai Murthy
    class Helper {
        int height = 0;
        boolean isBalanced = false;
        
        Helper(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    class Solution {
        public boolean isBalanced(TreeNode root) {
           return checkForBalance(root).isBalanced;
        }
        
        public Helper checkForBalance(TreeNode root) {
            if(root == null) {
                return new Helper(0, true);
            }
            
            Helper left = checkForBalance(root.left);
            Helper right = checkForBalance(root.right);
            
            return new Helper(Math.max(left.height, right.height) + 1, Math.abs(left.height - right.height) > 1 ? false  : left.isBalanced && right.isBalanced);
        }
    }
}