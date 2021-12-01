/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question7Solution
 * @date 2021/11/30 18:41
 */
public class Question7Solution {
    public static void main(String[] args) {
        Question7Solution solution = new Question7Solution();
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}}));
        System.out.println(solution.orangesRotting(new int[][]{{0,2}}));
    }

    // n is the number of cells in the input grid
    // Time: O(n ^ 2)
    // Space: O(1)
    public int orangesRotting(int[][] grid) {
        int time = 2;
        while (bfs(time, grid)) {
            time++;
        }
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 1) {
                    return -1;
                }
            }
        }
        return time - 2;
    }

    private static final int[][] DIRECTIONS = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private boolean bfs(int time, int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean toBeContinued = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == time) {
                    for (int[] direction : DIRECTIONS) {
                        int newRow = row + direction[0], newCol = col + direction[1];
                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                            if (grid[newRow][newCol] == 1) {
                                grid[newRow][newCol] = time + 1;
                                toBeContinued = true;
                            }
                        }
                    }
                }
            }
        }
        return toBeContinued;
    }
}
