import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3 Solution
 * @date 2021/9/14 23:51
 */
public class Question3Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        int[] data1 = new int[]{6, 2, 6, 5, 1, 2};
        int res1 = solution.maxSum(data1);
        System.out.println(res1);
        int[] data2 = new int[]{1, 4, 3, 2};
        int res2 = solution.maxSum(data2);
        System.out.println(res2);
    }

    // n is the length of array
    // Time: O(n * log(n))
    // Space: O(1)
    public int maxSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }
}
