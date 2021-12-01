/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/11/30 18:40
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        int[][] isConnected = new int[][]{{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution.findCircleNum(isConnected));
        isConnected = new int[][]{{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(solution.findCircleNum(isConnected));
    }

    // n is the length of the input isConnected
    // Time: O(n)
    // Space: O(n)
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int cur, int[][] isConnected, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[cur][i] == 1) {
                dfs(i, isConnected, visited);
            }
        }
    }
}
