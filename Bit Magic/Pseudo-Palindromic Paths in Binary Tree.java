/*
 * Leetcode problem : https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 */

class Solution {
    int noOfPaths = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        solve(root, 0);
        return noOfPaths;
    }

    public void solve(TreeNode root, int path) {
        if(root == null) {
            return;
        }

        path = path ^ (1 << root.val);
        if(root.left == null && root.right == null) {
            noOfPaths += (path & (path - 1)) == 0 ? 1 : 0;
        }
        solve(root.left, path);
        if(root.right != null) {
            solve(root.right, path);
        }
        path = path ^ (1 << root.val);

    }
}