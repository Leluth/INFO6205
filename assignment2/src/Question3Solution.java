import java.util.*;

/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3 Solution
 * @date 2021/9/21 18:41
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        int[] res = solution.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println(Arrays.toString(res));
        res = solution.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        System.out.println(Arrays.toString(res));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] res = new int[set2.size()];
        int count = 0;
        for (int num : set2) {
            res[count++] = num;
        }
        return res;
    }
}
