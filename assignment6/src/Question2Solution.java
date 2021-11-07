import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/11/6 22:24
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        TreeNode root1 = new TreeNode(0);
        TreeNode root2 = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.leafSimilar(root1, root2));
        root1 = new TreeNode(0, new TreeNode(1, new TreeNode(2), new TreeNode(3)), null);
        root2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.leafSimilar(root1, root2));
    }

    // m, n are the numbers of the nodes in the two input trees
    // Time: O(m + n)
    // Space: O(m + n)
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
