/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question1Solution
 * @date 2021/9/21 18:30
 */
public class Question1Solution {
    public static void main(String[] args) {
        Question1Solution solution = new Question1Solution();
        ListNode headA = new ListNode(2, new ListNode(4));
        ListNode headB = new ListNode(1, new ListNode(3));
        System.out.println(solution.getIntersectionNode(headA, headB));
        ListNode common = new ListNode(8, new ListNode(10));
        headA = new ListNode(2, new ListNode(4, common));
        headB = new ListNode(1, common);
        System.out.println(solution.getIntersectionNode(headA, headB));
    }

    // m is the numbers of nodes in LinkedList A, n is the number of nodes in LinkedList B
    // Time: O(m + n)
    // Space: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        if (lenA > lenB) {
            int diff = lenA - lenB;
            while (diff-- > 0) {
                headA = headA.next;
            }
        } else {
            int diff = lenB - lenA;
            while (diff-- > 0) {
                headB = headB.next;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private int getLength(ListNode head) {
        int res = 0;
        while (head != null) {
            res++;
            head = head.next;
        }
        return res;
    }
}
