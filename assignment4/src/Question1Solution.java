/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/10/10 10:15
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        ListNode head = new ListNode(4);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(1);
        ListNode forth = new ListNode(9);
        head.next = second;
        second.next = third;
        third.next = forth;
        solution.deleteNode(second);
        System.out.println(head);
        head = new ListNode(4);
        second = new ListNode(1);
        third = new ListNode(9);
        head.next = second;
        second.next = third;
        solution.deleteNode(second);
        System.out.println(head);
    }

    // Time: O(1)
    // Space: O(1)
    public void deleteNode(ListNode node) {
        ListNode nxtNode = node.next;
        node.val = nxtNode.val;
        node.next = nxtNode.next;
    }
}
