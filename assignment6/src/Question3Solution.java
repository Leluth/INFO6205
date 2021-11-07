/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3Solution
 * @date 2021/11/6 22:24
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        TreeNode root = new TreeNode(0);
        System.out.println(solution.hasPathSum(root, 1));
        root = new TreeNode(0, new TreeNode(2), new TreeNode(4));
        System.out.println(solution.hasPathSum(root, 4));
    }

    // n is the number of the nodes in the input tree
    // Time: O(n)
    // Space: O(n)
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null && targetSum == root.val) {
            return true;
        }
        targetSum -= root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
