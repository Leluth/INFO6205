/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: ListNode
 * @date 2021/9/28 19:27
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append(" -> ");
        ListNode cur = next;
        while (cur != null) {
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
