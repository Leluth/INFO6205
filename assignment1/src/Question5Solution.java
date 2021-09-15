import java.util.Arrays;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5 Solution
 * @date 2021/9/15 0:21
 */
public class Question5Solution {
    /**
     * @description: main function
     * @param: [args]
     * @return: void
     * @author: ssxu
     * @date: 2021/9/14 20:33
     */
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean res = solution.checkAnagram(s, t);
        System.out.println(res);
    }

    public boolean checkAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] sArray = s.toCharArray();
        Arrays.sort(sArray);
        char[] tArray = t.toCharArray();
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
