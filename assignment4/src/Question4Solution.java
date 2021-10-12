/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/10/10 10:16
 */
public class Question4Solution {
    public static void main(String[] args) {
        Question4Solution solution = new Question4Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solution.reverseBetween(head, 2, 4));
        head = new ListNode(5);
        System.out.println(solution.reverseBetween(head, 1, 1));
        head = new ListNode(5, new ListNode(4));
        System.out.println(solution.reverseBetween(head, 1, 2));
    }

    // Time: O(right)
    // Space: O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode leftNode = head;
        ListNode rightNode = head;
        ListNode curNode = dummyHead;
        int curIndex = 1;
        while (curNode.next != null) {
            if (left == curIndex) {
                leftNode = curNode;
            }
            if (right == curIndex) {
                rightNode = curNode.next;
                break;
            }
            curIndex++;
            curNode = curNode.next;
        }
        leftNode.next = reverse(leftNode.next, rightNode);
        return dummyHead.next;
    }

    public ListNode reverse(ListNode left, ListNode right) {
        ListNode tail = right.next;
        ListNode pre = right.next;
        ListNode cur = left;
        while (cur != tail) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
