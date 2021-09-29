/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/9/28 19:22
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(solution.oddEvenList(head));
        head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(solution.oddEvenList(head));
    }

    // n is the number of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curOdd = head;
        ListNode curEven = dummyHead;
        while (curOdd.next != null && curOdd.next.next != null) {
            curEven.next = curOdd.next;
            curEven = curEven.next;
            curOdd.next = curOdd.next.next;
            curOdd = curOdd.next;
            curEven.next = null;
        }
        if (curOdd.next != null) {
            curEven.next = curOdd.next;
            curEven = curEven.next;
            curEven.next = null;
        }
        curOdd.next = dummyHead.next;
        return head;
    }
}
