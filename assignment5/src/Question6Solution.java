/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6Solution
 * @date 2021/10/12 18:50
 */
public class Question6Solution {
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        System.out.println(solution.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(solution.pivotIndex(new int[]{1,2,3}));
        System.out.println(solution.pivotIndex(new int[]{2,1,-1}));

    }

    // n is the length of nums
    // Time: O(n)
    // Space: O(1)
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            rightSum -= num;
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += num;
        }
        return -1;
    }
}
