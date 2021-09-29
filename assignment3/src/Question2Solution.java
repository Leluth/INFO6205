/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/9/28 19:21
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        ListNode head = new ListNode(1, new ListNode(2));
        ListNode res = solution.removeElements(head, 2);
        System.out.println(res);
        head = null;
        res = solution.removeElements(head, 2);
        System.out.println(res);
    }

    // n is the numbers of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
