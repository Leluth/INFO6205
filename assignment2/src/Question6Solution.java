/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6 Solution
 * @date 2021/9/21 18:45
 */
public class Question6Solution {
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        int[][] grid1 = new int[][]{{4,3,2,-1}, {3,2,1,-1}, {1,1,-1,-2}, {-1,-1,-2,-3}};
        int res1 = solution.countNegatives(grid1);
        System.out.println(res1);
        int[][] grid2 = new int[][]{{3,2}, {1,0}};
        int res2 = solution.countNegatives(grid2);
        System.out.println(res2);
    }

    // m is the length of grid, n is the length of grid[0]
    // Time: O(m + n)
    // Space: O(1)
    public int countNegatives(int[][] grid) {
        int row = 0;
        int col = 0;
        int res = 0;
        while(row < grid.length && col < grid[0].length){
            if(grid[row][col] < 0){
                res += grid.length - row ;
                col--;
            }
            else{
                row++;
            }
        }
        return res;
    }
}
