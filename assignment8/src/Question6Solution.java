import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6Solution
 * @date 2021/11/30 18:41
 */
public class Question6Solution {
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{1,1},{1,1}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,1},{1,0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{0,0,1},{1,1,0},{1,1,0}}));
        System.out.println(solution.shortestPathBinaryMatrix(new int[][]{{1,0,0},{1,1,0},{1,1,0}}));
    }

    // n is the number of cells in the grid
    // Time: O(n)
    // Space: O(n)
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
            return -1;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        grid[0][0] = 1;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.remove();
            int row = cell[0];
            int col = cell[1];
            int distance = grid[row][col];
            if (row == grid.length - 1 && col == grid[0].length - 1) {
                return distance;
            }
            for (int[] neighbour : getNeighbours(row, col, grid)) {
                int neighbourRow = neighbour[0];
                int neighbourCol = neighbour[1];
                queue.add(new int[]{neighbourRow, neighbourCol});
                grid[neighbourRow][neighbourCol] = distance + 1;
            }
        }
        return -1;
    }

    private static final int[][] DIRECTIONS =
            new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private List<int[]> getNeighbours(int row, int col, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length
                    || newCol >= grid[0].length
                    || grid[newRow][newCol] != 0) {
                continue;
            }
            neighbours.add(new int[]{newRow, newCol});
        }
        return neighbours;
    }
}
