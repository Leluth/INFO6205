/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question2Solution
 * @date 2021/11/30 18:39
 */
public class Question2Solution {
    public static void main(String[] args) {
        Question2Solution solution = new Question2Solution();
        System.out.println(solution.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));
        System.out.println(solution.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5));
    }

    // m is the length of the input array edges
    // Time: O(n * m)
    // Space: O(n)
    public boolean validPath(int n, int[][] edges, int start, int end) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            nodes[i].join(nodes[j]);
        }
        return nodes[start].searchParent() == nodes[end].searchParent();
    }

    static class Node {
        private Node parent;

        public Node() {
            parent = this;
        }

        public void join(Node node) {
            this.parent = searchParent();
            node.parent = node.searchParent();
            this.parent.parent = node.parent;
        }

        public Node searchParent() {
            Node cur = this;
            while (cur.parent != cur) {
                cur = cur.parent;
            }
            return cur;
        }
    }
}
