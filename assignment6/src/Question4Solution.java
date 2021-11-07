/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/11/6 22:25
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1), null);
        System.out.println(solution.isBalanced(root));
        root = new TreeNode(0, new TreeNode(1, new TreeNode(2), null), null);
        System.out.println(solution.isBalanced(root));
    }

    // n is the number of the nodes in the input tree
    // Time: O(n)
    // Space: O(n)
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = getHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
