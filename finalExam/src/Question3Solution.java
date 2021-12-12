/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3Solution
 * @date 2021/12/12 10:26
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        System.out.println(solution.minJumpToReachEnd(new int[]{0}));
        System.out.println(solution.minJumpToReachEnd(new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}));
        System.out.println(solution.minJumpToReachEnd(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(solution.minJumpToReachEnd(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1}));
        System.out.println(solution.minJumpToReachEnd(new int[]{1, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1}));
    }

    public int minJumpToReachEnd(int[] array) {
        int min = 0;
        if (array == null || array.length <= 1) {
            return min;
        }
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < array.length - 1; i++) {
            farthest = Math.max(farthest, i + array[i]);
            if (i == currentEnd) {
                if (currentEnd == farthest) {
                    return -1;
                }
                min++;
                currentEnd = farthest;
            }
        }
        return min;
    }
}
