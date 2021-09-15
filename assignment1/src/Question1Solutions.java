/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Assignment1 Solutions
 * @date 2021/9/14 19:19
 */
public class Question1Solutions {
    /**
     * @description: TODO
     * @param: array
     * @return: int[]
     * @author: ssxu
     * @date: 2021/9/14 19:23
     */
    public int[] question1(int[] array) {
        // Write your solution here
        if(array.length <= 1) {
            return array;
        }

        int i = 0;
        int j = 0;
        int k = array.length - 1;
        while(j <= k) {
            if(array[j] == 0) {
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

    private void swap(int left, int right, int[] array) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
