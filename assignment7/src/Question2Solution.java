/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/11/14 10:47
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        System.out.println(solution.countArrangement(1));
        System.out.println(solution.countArrangement(2));
    }

    // k is the number of valid permutations
    // Time: O(k)
    // Space: O(N)
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        int[] count = new int[1];
        calculate(N, 1, visited, count);
        return count[0];
    }

    private void calculate(int N, int pos, boolean[] visited, int[] count) {
        if (pos > N) {
            count[0]++;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited, count);
                visited[i] = false;
            }
        }
    }
}
