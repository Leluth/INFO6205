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
        String s1 = "anagram";
        String t1 = "nagaram";
        boolean res1 = solution.checkAnagram(s1, t1);
        System.out.println(res1);
        String s2 = "rat";
        String t2 = "car";
        boolean res2 = solution.checkAnagram(s2, t2);
        System.out.println(res2);
    }

    // m is the length of s, n is th length of t
    // Time: O(m * log(m) + n * log(n))
    // Space: O(m + n)
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
