/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question8Solution
 * @date 2021/10/12 18:50
 */
public class Question8Solution {
    public static void main(String[] args) {
        Question8Solution solution = new Question8Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2}, 8));
        System.out.println(solution.search(new int[]{1}, 0));
    }

    // n is the length of nums
    // Time: O(log(n))
    // Space: O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int mid = findMid(nums);
        int res = search(nums, 0, mid - 1, target);
        if (res == -1) {
            res = search(nums, mid, nums.length - 1, target);
        }
        return res;
    }

    private int search(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findMid(int[] nums) {
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        if (nums[leftIndex] <= nums[rightIndex]) {
            return leftIndex;
        }
        while (leftIndex <= rightIndex) {
            int midIndex = leftIndex + (rightIndex - leftIndex) / 2;
            int midVal = nums[midIndex];
            int leftVal = midIndex == 0 ? Integer.MAX_VALUE : nums[midIndex - 1];
            int rightVal = midIndex == nums.length - 1 ? Integer.MAX_VALUE : nums[midIndex + 1];
            if (midVal < leftVal && midVal < rightVal) {
                return midIndex;
            } else if (midVal >= nums[0]) {
                leftIndex = midIndex + 1;
            } else {
                rightIndex = midIndex - 1;
            }
        }
        return -1;
    }
}
