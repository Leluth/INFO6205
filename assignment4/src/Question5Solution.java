/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5Solution
 * @date 2021/10/10 10:17
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        ListNode head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(solution.getDecimalValue(head));
        head = new ListNode(1);
        System.out.println(solution.getDecimalValue(head));
        head = new ListNode(0, new ListNode(0));
        System.out.println(solution.getDecimalValue(head));
    }

    // n is the number of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = (num << 1) | head.next.val;
            head = head.next;
        }
        return num;
    }
}
