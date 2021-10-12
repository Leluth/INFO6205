/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/10/10 10:15
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = first;
        System.out.println(solution.insert(second, 5).loopDisplay());
        System.out.println(solution.insert(null, 0).loopDisplay());
        ListNode selfLoop = new ListNode(0);
        selfLoop.next = selfLoop;
        System.out.println(solution.insert(selfLoop, 1).loopDisplay());
        selfLoop = new ListNode(0);
        selfLoop.next = selfLoop;
        System.out.println(solution.insert(selfLoop, 0).loopDisplay());

    }

    // n is the number of nodes in LinkedList
    // Time: O(n)
    // Space: O(1)
    public ListNode insert(ListNode head, int insertVal) {
        ListNode insertNode = new ListNode(insertVal);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        ListNode cur = head;
        do {
            if (cur.val == insertVal) {
                break;
            }
            if (cur.val < insertVal && cur.next.val > insertVal) {
                break;
            }
            if (cur.val > cur.next.val && (insertVal > cur.val || insertVal < cur.next.val)) {
                break;
            }
            cur = cur.next;
        } while (cur != head);
        insertNode.next = cur.next;
        cur.next = insertNode;
        return head;
    }
}
