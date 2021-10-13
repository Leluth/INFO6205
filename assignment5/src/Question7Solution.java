import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question7Solution
 * @date 2021/10/12 18:50
 */
public class Question7Solution {
    public static void main(String[] args) {
        Question7Solution solution = new Question7Solution();
        System.out.println(Arrays.deepToString(solution.highFive(new int[][]{{1,100},{1,100},{1,100},{1,100},{1,100},
                {7,100},{7,100},{7,100},{7,100},{7,100}})));
        System.out.println(Arrays.deepToString(solution.highFive(new int[][]{{1,100},{1,100},{1,100},{1,100},{1,100},
                {7,100},{7,200},{7,300},{7,500},{7,400},{7,800}})));
    }

    // n is the length of items
    // Time: O(n * log(n))
    // Space: O(n)
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(a[0], b[0]);
                    }
                    return -Integer.compare(a[1], b[1]);
                });
        List<int[]> solution = new ArrayList<>();
        int len = items.length;
        int left = 0;
        while (left < len) {
            int cur = items[left][0];
            int sum = 0;
            for (int right = left; right < Math.min(len, left + 5); right++) {
                sum += items[right][1];
            }
            while (left < len && items[left][0] == cur) {
                left++;
            }
            solution.add(new int[]{cur, sum / 5});
        }
        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);
    }
}
