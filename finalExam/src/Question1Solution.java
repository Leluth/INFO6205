import java.util.HashMap;
import java.util.Map;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/12/12 10:24
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        int[] inOrder = new int[]{0};
        int[] levelOrder = new int[]{0};
        System.out.println(solution.createTreeFromInOrderAndLevelOrder(inOrder, levelOrder));

        inOrder = new int[]{3,1,4,0,5,2,6};
        levelOrder = new int[]{0,1,2,3,4,5,6};
        System.out.println(solution.createTreeFromInOrderAndLevelOrder(inOrder, levelOrder));

        inOrder = new int[]{7,5,0,1,8,4};
        levelOrder = new int[]{1,0,4,5,8,7};
        System.out.println(solution.createTreeFromInOrderAndLevelOrder(inOrder, levelOrder));
    }

    public TreeNode createTreeFromInOrderAndLevelOrder(int[] inOrder, int[] levelOrder) {
        if (inOrder == null || inOrder.length == 0 || levelOrder == null || levelOrder.length == 0
                || inOrder.length != levelOrder.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < levelOrder.length; i++) {
            map.put(levelOrder[i], i);
        }
        return helper(0, inOrder.length - 1, inOrder, map);
    }

    private TreeNode helper(int leftIndex, int rightIndex, int[] inOrder, Map<Integer, Integer> map) {
        if (leftIndex > rightIndex) {
            return null;
        } if (leftIndex == rightIndex) {
            return new TreeNode(inOrder[leftIndex]);
        }
        int minIndex = leftIndex;
        int minOrder = map.get(inOrder[minIndex]);
        for (int currentIndex = leftIndex + 1; currentIndex <= rightIndex; currentIndex++) {
            int currentOrder = map.get(inOrder[currentIndex]);
            if (currentOrder < minOrder) {
                minIndex = currentIndex;
                minOrder = currentOrder;
            }
        }
        TreeNode root = new TreeNode(inOrder[minIndex]);
        root.left = helper(leftIndex, minIndex - 1, inOrder, map);
        root.right = helper( minIndex + 1, rightIndex, inOrder, map);
        return root;
    }
}
