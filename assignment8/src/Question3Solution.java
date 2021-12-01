import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3Solution
 * @date 2021/11/30 18:39
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        char[][] grid = new char[][]{{'1','0','1'}};
        System.out.println(solution.numIslands(grid));
        grid = new char[][]{{'1','0','1'},{'1','1','1'}};
        System.out.println(solution.numIslands(grid));
    }

    // m is the length of grid, and n is the length of grid[0]
    // Time: O(m * n)
    // Space: O(m * n)
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(i, j, grid);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if (i - 1 >= 0 && grid[i -1][j] == '1') {
            dfs(i - 1, j, grid);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            dfs(i, j - 1, grid);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            dfs(i + 1, j, grid);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            dfs(i, j + 1, grid);
        }
    }
}
