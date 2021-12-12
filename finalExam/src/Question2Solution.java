/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/12/12 10:25
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        System.out.println(solution.isFoldable(root));

        root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(11);
        System.out.println(solution.isFoldable(root));

        root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(11);
        System.out.println(solution.isFoldable(root));

        root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(12);
        System.out.println(solution.isFoldable(root));
    }

    public boolean isFoldable(TreeNode root) {
        if (root == null) {
            return true;
        }
        return similar(root.left, root.right);
    }

    private boolean similar(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        } else if (rootA == null || rootB == null) {
            return false;
        }
        return similar(rootA.left, rootB.right) && similar(rootA.right, rootB.left);
    }
}
