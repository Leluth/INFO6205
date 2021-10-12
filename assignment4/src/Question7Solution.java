/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question7Solution
 * @date 2021/10/10 10:19
 */
public class Question7Solution {
    public static void main(String[] args) {
        Question7Solution solution = new Question7Solution();
        PolyNode poly1 = new PolyNode(1, 1);
        PolyNode poly2 = new PolyNode(1, 0);
        System.out.println(solution.addPoly(poly1, poly2));
        poly1 = new PolyNode(1, 2);
        poly2 = new PolyNode(-1, 2);
        System.out.println(solution.addPoly(poly1, poly2));
    }

    static class PolyNode {
        int coefficient, power;
        PolyNode next = null;

        PolyNode() {
        }

        PolyNode(int x, int y) {
            this.coefficient = x;
            this.power = y;
        }

        PolyNode(int x, int y, PolyNode next) {
            this.coefficient = x;
            this.power = y;
            this.next = next;
        }

        @Override
        public String toString() {
            return "PolyNode{" +
                    "coefficient=" + coefficient +
                    ", power=" + power +
                    ", next=" + next +
                    '}';
        }
    }

    // m is the numbers of nodes in poly1, n is the number of nodes in poly2
    // Time: O(m + n)
    // Space: O(1)
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummyHead = new PolyNode();
        PolyNode cur = dummyHead;
        while (poly1 != null || poly2 != null) {
            if (poly1 != null && (poly2 == null || poly1.power > poly2.power)) {
                cur.next = new PolyNode(poly1.coefficient, poly1.power);
                cur = cur.next;
                poly1 = poly1.next;
            } else if (poly1 == null || poly1.power < poly2.power) {
                cur.next = new PolyNode(poly2.coefficient, poly2.power);
                cur = cur.next;
                poly2 = poly2.next;
            } else if (poly2.coefficient + poly1.coefficient != 0) {
                cur.next = new PolyNode(poly2.coefficient + poly1.coefficient, poly1.power);
                cur = cur.next;
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else {
                poly1 = poly1.next;
                poly2 = poly2.next;
            }
        }
        return dummyHead.next;
    }
}
