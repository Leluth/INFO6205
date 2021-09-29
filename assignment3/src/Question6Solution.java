/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6Solution
 * @date 2021/9/28 19:23
 */
public class Question6Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node1;
        System.out.println(solution.detectCycle(head).val);
        node1 = new ListNode(2);
        node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        System.out.println(solution.detectCycle(head));
    }

    // n is the number of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
