import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3Solution
 * @date 2021/11/14 10:48
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
        System.out.println(solution.restoreIpAddresses("101023"));
    }

    // Time: O(27)
    // Space: O(19)
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        List<String> path = new ArrayList<>();
        dfs(-1, 3, s, path, res);
        return res;
    }

    private void dfs(int preEnd, int dots, String s, List<String> path, List<String> res) {
        int maxEnd = Math.min(s.length() - 1, preEnd + 4);
        for (int curEnd = preEnd + 1; curEnd < maxEnd; curEnd++) {
            String segment = s.substring(preEnd + 1, curEnd + 1);
            if (valid(segment)) {
                path.add(segment);
                if (dots - 1 == 0) {
                    tryUpdate(curEnd, s, path, res);
                } else {
                    dfs(curEnd, dots - 1, s, path, res);
                }
                path.remove(path.size() - 1);
            }
        }
    }

    private void tryUpdate(int curPos, String s, List<String> path, List<String> res) {
        String segment = s.substring(curPos + 1);
        if (valid(segment)) {
            path.add(segment);
            res.add(String.join(".", path));
            path.remove(path.size() - 1);
        }
    }

    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3) {
            return false;
        }
        return (segment.charAt(0) != '0') ? (Integer.parseInt(segment) <= 255) : (m == 1);
    }
}
