/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/10/12 18:49
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        System.out.println(solution.countAndSay(1));
        System.out.println(solution.countAndSay(4));
    }

    // Time: O(2 ^ n)
    // Space: O(n)
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String pre = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int len = pre.length();
        for (int i = 0; i < len; i++) {
            int count = 1;
            while (i < len - 1 && pre.charAt(i + 1) == pre.charAt(i)) {
                count++;
                i++;
            }
            sb.append(count);
            sb.append(pre.charAt(i));
        }
        return sb.toString();
    }
}
