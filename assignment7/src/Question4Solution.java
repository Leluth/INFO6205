import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/11/14 10:48
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        char[][] board = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(solution.findWords(board, words));
        board = new char[][]{{'a','b'},{'c','d'}};
        words = new String[]{"abcb"};
        System.out.println(solution.findWords(board, words));
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        String word = null;
    }

    // m is the rows of the board, n is the cols of the board
    // l is the maximum length of word in words, c is the total number of letters in words
    // Time: O(m * n * 3 ^ l + c)
    // Space: O(c)
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(i, j, root, board, res);
            }
        }
        return res;
    }

    private void dfs(int row, int col, TrieNode parent, char[][] board, List<String> res) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                parent.children.get(board[row][col]) == null) {
            return;
        }
        Character curChar = board[row][col];
        TrieNode curNode = parent.children.get(curChar);
        if (curNode.word != null) {
            res.add(curNode.word);
            curNode.word = null;
        }
        board[row][col] = ' ';
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            dfs(newRow, newCol, curNode, board, res);
        }
        board[row][col] = curChar;
        if (curNode.children.isEmpty()) {
            parent.children.remove(curChar);
        }
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (Character c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
        return root;
    }
}
