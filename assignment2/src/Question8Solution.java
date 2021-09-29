/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question8 Solution
 * @date 2021/9/21 18:47
 */
public class Question8Solution {
    public static void main(String[] args) {
        Question8Solution solution = new Question8Solution();
        int res1 = solution.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println(res1);
        int res2 = solution.findDuplicate(new int[]{1, 1});
        System.out.println(res2);
    }

    // n is the length of nums
    // Time: O(n)
    // Space: O(n)
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            if (visited[num]) {
                return num;
            }
            visited[num] = true;
        }
        return -1;
    }
}
