/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question5 Solution
 * @date 2021/9/28 19:23
 */
public class Question5Solution {
    public static void main(String[] args) {
        Question5Solution solution = new Question5Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(solution.middleNode(head));
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(solution.middleNode(head));
    }

    // n is the number of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
