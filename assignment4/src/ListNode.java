import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        if (next != null && listNode.next == null || (next == null && listNode.next != null)) {
            return false;
        }
        return val == listNode.val && (next == null || next.val == listNode.next.val);
    }

    public String loopDisplay() {
        Set<ListNode> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        sb.append(" -> ");
        set.add(this);
        ListNode cur = next;
        while (cur != null) {
            if (set.contains(cur)) {
                sb.append(val);
                return sb.toString();
            }
            set.add(cur);
            sb.append(cur.val);
            sb.append(" -> ");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
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
