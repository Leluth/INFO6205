import java.util.HashMap;
import java.util.Map;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/12/12 10:27
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        String[] words = new String[]{"hh","ll","hh"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isValid(words, order));

        words = new String[]{"hello","leetcode"};
        order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(solution.isValid(words, order));

        words = new String[]{"word","world","row"};
        order = "worldabcefghijkmnpqstuvxyz";
        System.out.println(solution.isValid(words, order));

        words = new String[]{"apple","app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(solution.isValid(words, order));
    }

    public boolean isValid(String[] words, String order) {
        if (order == null) {
            return false;
        }
        if (words == null || words.length <= 1) {
            return true;
        }
        Map<Character, Integer> map = buildMap(order);
        for (int i = 1; i < words.length; i++) {
            String left = words[i - 1];
            String right = words[i];
            if (left.length() > right.length() && left.startsWith(right)) {
                return false;
            }
            int endIndex = Math.min(left.length(), right.length());
            int index = 0;
            while (index < endIndex && left.charAt(index) == right.charAt(index)) {
                index++;
            }
            if (index == endIndex) {
                continue;
            }
            if (map.get(left.charAt(index)) > map.get(right.charAt(index))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> buildMap(String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        return map;
    }
}
