/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5Solution
 * @date 2021/10/12 18:49
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }

    // n is the length of prices
    // Time: O(n)
    // Space: O(1)
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices == null || prices.length <= 1) {
            return max;
        }
        int preMinPrice = prices[0];
        for (int day = 1; day < prices.length; day++) {
            max = Math.max(max, prices[day] - preMinPrice);
            preMinPrice = Math.min(preMinPrice, prices[day]);
        }
        return max;
    }
}
