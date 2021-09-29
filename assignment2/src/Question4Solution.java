import java.util.ArrayList;
import java.util.List;

/**
 * @author Shaosahui Xu
 * @version 1.0
 * @description: Question4 Solution
 * @date 2021/9/21 18:41
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        List<Integer> list = solution.majorityElement(new int[] {1, 2});
        System.out.println(list);
        list = solution.majorityElement(new int[] {3, 2, 3});
        System.out.println(list);
    }

    // n is the length of nums
    // Time: O(n)
    // Space: O(1)
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        int count1 = 0;
        int count2 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            } else if (num == num2) {
                count2++;
            } else if (count1 > 0 && count2 > 0) {
                count1--;
                count2--;
            } else if (count1 == 0) {
                num1 = num;
                count1++;
            } else {
                num2 = num;
                count2++;
            }
        }
        int target = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == num1) {
                count1++;
            }else if (num == num2) {
                count2++;
            }
        }
        if (count1 > target) {
            res.add(num1);
        }
        if (count2 > target) {
            res.add(num2);
        }
        return res;
    }
}
