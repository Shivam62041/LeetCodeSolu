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
    public int countNodes(TreeNode root) {
        return counter(root);
    }
    public int counter(TreeNode node){
        if(node==null){
            return 0;
        }
        int ls = counter(node.left);
        int rs = counter(node.right);
        return ls+rs+1;
    }
}