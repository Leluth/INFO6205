/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question7 Solution
 * @date 2021/9/21 18:46
 */
public class Question7Solution {
    public static void main(String[] args) {
        Question7Solution solution = new Question7Solution();
        int res1 = solution.findPeakElement(new int[]{1,2,3,1});
        System.out.println(res1);
        int res2 = solution.findPeakElement(new int[]{1,2,3,4,3,2});
        System.out.println(res2);
    }

    // n is the length of nums
    // Time: O(log(n))
    // Space: O(1)
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return findPeakElement(nums, 0, nums.length - 1);
    }

    private int findPeakElement(int[] nums, int left, int right) {
        while (right - left > 1) {
            int midIndex = left + (right - left) / 2;
            int mid = nums[midIndex];
            int l = nums[midIndex - 1];
            int r = nums[midIndex + 1];
            if (mid > l && mid > r) {
                return midIndex;
            } else if (mid >= l && mid <= r) {
                left = midIndex + 1;
            } else {
                right = midIndex - 1;
            }
        }
        if (left == right) {
            return left;
        } else if (nums[left] > nums[right]) {
            return left;
        } else if (nums[left] < nums[right]) {
            return right;
        }
        return -1;
    }
}
