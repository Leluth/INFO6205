/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question6Solution
 * @date 2021/10/10 10:19
 */
public class Question6Solution {
    public static void main(String[] args) {
        Question6Solution solution = new Question6Solution();
        FrontMiddleBackQueue q = new FrontMiddleBackQueue();
        q.pushFront(1);
        q.pushBack(2);
        q.pushMiddle(3);
        q.pushMiddle(4);
        System.out.println(q.popFront());
        System.out.println(q.popMiddle());
        System.out.println(q.popMiddle());
        System.out.println(q.popBack());
        System.out.println(q.popFront());
    }

    static class FrontMiddleBackQueue {
        static class Node {
            int val;
            Node next;
            Node prev;

            public Node(int val) {
                this.val = val;
            }
        }

        Node head;
        Node tail;
        Node mid;
        int size;

        public FrontMiddleBackQueue() {
            head = null;
            tail = null;
            mid = null;
            size = 0;
        }

        // Time: O(1)
        // Space: O(1)
        public void pushFront(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
                mid = newNode;
                size++;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
                size++;
                if (size % 2 == 0) {
                    mid = mid.prev;
                }
            }
        }

        // Time: O(1)
        // Space: O(1)
        public void pushMiddle(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
                mid = newNode;
                size++;
            } else {
                if (size == 1) {
                    newNode.next = head;
                    head.prev = newNode;
                    head = newNode;
                } else {
                    if (size % 2 != 0) {
                        newNode.next = mid;
                        newNode.prev = mid.prev;
                        mid.prev.next = newNode;
                        mid.prev = newNode;
                    } else {
                        newNode.prev = mid;
                        newNode.next = mid.next;
                        mid.next.prev = newNode;
                        mid.next = newNode;
                    }
                    mid = newNode;
                }
                size++;
                mid = newNode;
            }
        }

        // Time: O(1)
        // Space: O(1)
        public void pushBack(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
                mid = newNode;
                size++;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                size++;
                if (size % 2 != 0) {
                    mid = mid.next;
                }
            }
        }

        // Time: O(1)
        // Space: O(1)
        public int popFront() {
            if (head != null) {
                if (size % 2 == 0) {
                    mid = mid.next;
                }
                size--;
                int res = head.val;
                head = head.next;
                if (head != null && head.next != null) {
                    head.prev = null;
                }
                return res;
            }
            return -1;
        }

        // Time: O(1)
        // Space: O(1)
        public int popMiddle() {
            if (head != null) {
                int res;
                if (size == 1) {
                    res = head.val;
                    head = null;
                    size--;
                    mid = null;
                } else {
                    res = mid.val;
                    if (mid == head) {
                        head = head.next;
                        head.prev = null;
                        mid = head;
                    } else {
                        mid.next.prev = mid.prev;
                        mid.prev.next = mid.next;
                        if (size % 2 != 0) {
                            mid = mid.prev;
                        } else {
                            mid = mid.next;
                        }
                    }
                    size--;
                }
                return res;
            }
            return -1;
        }

        // Time: O(1)
        // Space: O(1)
        public int popBack() {
            if (head != null) {
                if (size % 2 != 0) {
                    mid = mid.prev;
                }
                size--;
                int res;
                if (head.next == null) {
                    res = head.val;
                    head = null;
                } else {
                    res = tail.val;
                    tail.prev.next = tail.next;
                    tail = tail.prev;
                }
                return res;
            }
            return -1;
        }
    }
}
