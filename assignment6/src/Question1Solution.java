/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/9/21 18:30
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        TreeNode t1 = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        TreeNode t2 = new TreeNode(0, null, new TreeNode(2));
        System.out.println(solution.mergeTrees(t1, t2));
        t1 = new TreeNode(0, new TreeNode(1), null);
        t2 = new TreeNode(0);
        System.out.println(solution.mergeTrees(t1, t2));
    }

    // n is the number of the overlapping nodes between the two trees
    // Time: O(n)
    // Space: O(n)
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
