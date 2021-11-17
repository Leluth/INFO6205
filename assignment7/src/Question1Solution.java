/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/9/21 18:30
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board, word));
        board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        word = "ABCB";
        System.out.println(solution.exist(board, word));
    }

    // m is the rows of board, n is cols of board, l is the length of word
    // Time: O(m * n * 3 ^ l)
    // Space: O(l)
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] board, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == ' ' ||
                board[i][j] != word.charAt(index)) {
            return false;
        }
        char cur = board[i][j];
        board[i][j] = ' ';
        boolean res = dfs(i - 1, j, board, index + 1, word) || dfs(i + 1, j, board, index + 1, word)
                || dfs(i, j - 1, board, index + 1, word) || dfs(i, j + 1, board, index + 1, word);
        board[i][j] = cur;
        return res;
    }
}
