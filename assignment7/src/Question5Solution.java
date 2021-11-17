import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5Solution
 * @date 2021/11/14 10:49
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        List<String> arr = new ArrayList<>();
        arr.add("un");
        arr.add("iq");
        arr.add("ue");
        System.out.println(solution.maxLength(arr));
        arr = new ArrayList<>();
        arr.add("cha");
        arr.add("r");
        arr.add("act");
        arr.add("ers");
        System.out.println(solution.maxLength(arr));
        arr = new ArrayList<>();
        arr.add("aaa");
        arr.add("bbbb");
        arr.add("c");
        System.out.println(solution.maxLength(arr));
        arr = new ArrayList<>();
        arr.add("abcdefghijklmnopqrstuvwxyz");
        System.out.println(solution.maxLength(arr));
    }

    // n is the length of the arr
    // Time: O(2 ^ n)
    // Space: O(n)
    public int maxLength(List<String> arr) {
        Set<Integer> set = new HashSet<>();
        for (String word : arr) {
            wordToSet(set, word);
        }
        int[] array = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            array[i++] = num;
        }
        return dfs(array, 0, 0, 0);
    }

    private int dfs(int[] array, int index, int curChars, int curLen) {
        int maxLen = curLen;
        for (int i = index; i < array.length; i++) {
            int newChars = array[i] & ((1 << 26) - 1);
            int newLen = array[i] >> 26;
            if ((curChars & newChars) > 0) {
                continue;
            }
            maxLen = Math.max(maxLen, dfs(array, i + 1, curChars + newChars, curLen + newLen));
        }
        return maxLen;
    }

    private void wordToSet(Set<Integer> set, String word) {
        int chars = 0;
        for (char c : word.toCharArray()) {
            int index = 1 << c - 'a';
            if ((chars & index) > 0) {
                return;
            }
            chars += index;
        }
        set.add(chars + (word.length() << 26));
    }
}
