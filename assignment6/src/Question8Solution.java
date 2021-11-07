import java.util.*;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question8Solution
 * @date 2021/11/6 22:26
 */
public class Question8Solution {
    public static void main(String[] args) {
        Question8Solution solution = new Question8Solution();
        TreeNode root = new TreeNode(0, new TreeNode(1), new TreeNode(2));
        System.out.println(solution.verticalTraversal(root));
        root = new TreeNode(0,
                new TreeNode(1, new TreeNode(3), new TreeNode(5)),
                new TreeNode(2, new TreeNode(4), null));
        System.out.println(solution.verticalTraversal(root));
        root = new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3));
        System.out.println(solution.verticalTraversal(root));
    }

    // n is the number of the nodes in the input tree
    // Time: O(n)
    // Space: O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, -1, map);
        int left = 0;
        int right = 0;
        for (int i : map.keySet()) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        for (int j = left; j <= right; j++) {
            List<Integer> temp = map.get(j);
            if (temp != null) {
                res.add(map.get(j));
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int index, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(index, new ArrayList<>());
        map.get(index).add(root.val);
        dfs(root.left, index - 1, map);
        dfs(root.right, index + 1, map);
    }
}
