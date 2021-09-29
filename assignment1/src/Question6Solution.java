import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6 Solution
 * @date 2021/9/15 0:28
 */
public class Question6Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        int[] data1 = new int[]{3, 1, 2, 4};
        int[] res1 = solution.sort(data1);
        System.out.println(Arrays.toString(res1));
        int[] data2 = new int[]{0};
        int[] res2 = solution.sort(data2);
        System.out.println(Arrays.toString(res2));
    }

    // n is the length of nums
    // Time: O(n)
    // Space: O(1)
    public int[] sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int even = 0;
        int odd = nums.length - 1;
        while (even < odd) {
            if (nums[even] % 2 != 0) {
                swap(even, odd, nums);
                odd--;
            } else {
                even++;
            }
        }
        return nums;
    }

    private void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
