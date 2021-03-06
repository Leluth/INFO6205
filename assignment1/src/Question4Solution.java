import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4 Solution
 * @date 2021/9/15 0:04
 */
public class Question4Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        int[] data1 = new int[]{-7, -3, 2, 3, 11};
        int[] res1 = solution.squareSort(data1);
        System.out.println(Arrays.toString(res1));
        int[] data2 = new int[]{-4, -1, 0, 3, 10};
        int[] res2 = solution.squareSort(data2);
        System.out.println(Arrays.toString(res2));
    }

    // n is the length of nums
    // Time: O(n)
    // Space: O(1)
    public int[] squareSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }
        int[] res = new int[nums.length];
        int zeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                break;
            } else if (nums[i] > 0) {
                break;
            } else {
                zeroIndex++;
            }
        }
        int small = zeroIndex;
        int big = zeroIndex + 1;
        for (int j = 0; j < res.length; j++) {
            if (small < 0 || big < nums.length && Math.abs(nums[small]) > Math.abs(nums[big])) {
                res[j] = nums[big] * nums[big];
                big++;
            } else {
                res[j] = nums[small] * nums[small];
                small--;
            }
        }
        return res;
    }
}
