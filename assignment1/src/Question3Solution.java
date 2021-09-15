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
        int[] data = new int[]{6, 2, 6, 5, 1, 2};
        int res = solution.maxSum(data);
        System.out.println(res);
    }

    public int maxSum(int[] array) {
        Arrays.sort(array);
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }
}
