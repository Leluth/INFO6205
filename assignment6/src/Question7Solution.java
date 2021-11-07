/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question7Solution
 * @date 2021/11/6 22:26
 */
public class Question7Solution {
    public static void main(String[] args) {
        Question7Solution solution = new Question7Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        solution.flatten(root);
        System.out.println(root);
        root = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(4));
        solution.flatten(root);
        System.out.println(root);
    }

    // n is the number of the nodes in the input tree
    // Time: O(n)
    // Space: O(n)
    public void flatten(TreeNode root) {
        if (root != null) {
            findTail(root);
        }
    }

    private TreeNode findTail(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode tail;
        if (left != null) {
            tail = findTail(left);
            root.left = null;
            root.right = left;
            tail.right = right;
        } else {
            tail = root;
        }
        if (tail.right == null) {
            return tail;
        } else {
            return findTail(tail.right);
        }
    }
}
