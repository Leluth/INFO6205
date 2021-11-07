/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5Solution
 * @date 2021/11/6 22:25
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        TreeNode subRoot = new TreeNode(4);
        System.out.println(solution.isSubtree(root, subRoot));
        subRoot = new TreeNode(2);
        System.out.println(solution.isSubtree(root, subRoot));
    }

    // m, n are the numbers of the nodes in the input tree root and subRoot
    // Time: O(m * n)
    // Space: O(min(m, n))
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null) {
            return false;
        }
        if (isSameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }
}
