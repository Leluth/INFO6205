/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question3Solution
 * @date 2021/9/28 19:22
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(solution.addTwoNumbers(l1, l2));
        l1 = new ListNode(0);
        l2 = new ListNode(0);
        System.out.println(solution.addTwoNumbers(l1, l2));
    }

    // m is the numbers of nodes in LinkedList l1, n is the numbers of nodes in LinkedList l2
    // Time: O(Max(m, n))
    // Space: O(1)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int remain = 0;
        while (l1 != null || l2 != null || remain > 0) {
            int curVal = remain;
            if (l1 != null) {
                curVal += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curVal += l2.val;
                l2 = l2.next;
            }
            remain = curVal / 10;
            curVal = curVal % 10;
            cur.next = new ListNode(curVal);
            cur = cur.next;
        }
        return dummyHead.next;
    }
}
