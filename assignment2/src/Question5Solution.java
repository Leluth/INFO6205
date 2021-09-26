import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5 Solution
 * @date 2021/9/21 18:44
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        int[] nums1 = new int[]{5,7,7,8,8,10};
        int target1 = 8;
        int[] res1 = solution.searchRange(nums1, target1);
        System.out.println(Arrays.toString(res1));
        int[] nums2 = new int[]{5,7,7,8,8,10};
        int target2 = 4;
        int[] res2 = solution.searchRange(nums2, target2);
        System.out.println(Arrays.toString(res2));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length <= 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return res;
        }
        res[0] = findFirst(nums, target, 0, nums.length - 1);
        if (res[0] > -1) {
            res[1] = findLast(nums, target, res[0], nums.length - 1);
        }
        return res;
    }

    private int findFirst(int[] nums, int target, int left, int right) {
        while (right - left > 0) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int findLast(int[] nums, int target, int left, int right) {
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
