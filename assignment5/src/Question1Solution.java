/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/9/21 18:30
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("    -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("9223372036854775808"));
    }

    // n is the length of the input string
    // Time: O(n)
    // Space: O(1)
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        int len = s.length();
        int cur = 0;
        boolean negative = false;
        while (cur < len && s.charAt(cur) == ' ') {
            if (cur == len - 1) {
                return 0;
            }
            cur++;
        }
        if (s.charAt(cur) == '-') {
            negative = true;
            cur++;
        } else if (s.charAt(cur) == '+') {
            cur++;
        }
        while (cur < len && Character.isDigit(s.charAt(cur))) {
            long temp = res * 10L + s.charAt(cur) - '0';
            if (!negative && Integer.MAX_VALUE < temp) {
                return Integer.MAX_VALUE;
            } else if (negative && Integer.MIN_VALUE > - temp) {
                return Integer.MIN_VALUE;
            }
            res = (int) temp;
            cur++;
        }
        return negative ? -res : res;
    }
}
