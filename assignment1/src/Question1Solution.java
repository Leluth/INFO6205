import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Assignment1 Solutions
 * @date 2021/9/14 19:19
 */
public class Question1Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        int[] res = solution.question1(new int[]{2,0,2,1,1,0});
        System.out.println(Arrays.toString(res));
    }

    /**
     * @description: question1 solution
     * @param: [array]
     * @return: int[]
     * @author: ssxu
     * @date: 2021/9/14 20:30
     */
    public int[] question1(int[] array) {
        // Write your solution here
        if (array.length <= 1) {
            return array;
        }

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while (j <= k) {
            if (array[j] == 0) {
                swap(i, j, array);
                i++;
                j++;
            } else if (array[j] == 1) {
                j++;
            } else {
                swap(j, k, array);
                k--;
            }
        }

        return array;
    }

    /**
     * @description: swap helper function
     * @param: [left, right, array]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:28
     */
    private void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
