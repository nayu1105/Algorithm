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
    TreeNode pre = null;
    int count = 0;
    int target = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        target = k;
        dfs(root);
        return answer;
    }

    public void dfs(TreeNode node){        
        if(node==null) return;

        dfs(node.left);
        count++;
        if(count == target){
            answer = node.val;
            return;
        }
        pre = node;
        dfs(node.right);
    }
}