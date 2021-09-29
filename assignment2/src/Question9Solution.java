/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question9 Solution
 * @date 2021/9/21 18:47
 */
public class Question9Solution {
    public static void main(String[] args) {
        Question9Solution solution = new Question9Solution();
        int res1 = solution.findKthPositive(new int[]{2,3,4,7,11}, 5);
        System.out.println(res1);
        int res2 = solution.findKthPositive(new int[]{1,2,3,4}, 2);
        System.out.println(res2);
    }

    // Time: O(k)
    // Space: O(1)
    public int findKthPositive(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return k;
        }
        int target = 1;
        int index = 0;
        int count = 0;
        while (count < k) {
            if (index < arr.length && target == arr[index]) {
                index++;
            } else {
                count++;
            }
            target++;
        }
        return target - 1;
    }
}
