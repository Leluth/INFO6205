/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6Solution
 * @date 2021/11/6 22:25
 */
public class Question6Solution {
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1), null);
        System.out.println(solution.isSymmetric(root));
        root = new TreeNode(0, new TreeNode(1), new TreeNode(1));
        System.out.println(solution.isSymmetric(root));
    }

    // n is the number of the nodes in the input tree
    // Time: O(n)
    // Space: O(n)
    public boolean isSymmetric(TreeNode root) {
        if(root==null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left==null && right==null) {
            return true;
        }
        if(left==null || right==null) {
            return false;
        }
        return (left.val==right.val)
                && isMirror(left.right, right.left)
                && isMirror(left.left, right.right);
    }
}
