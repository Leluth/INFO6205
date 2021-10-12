/**
 * @author Shaoshuai Xu
 * @version 1.0
 * @description: Question4Solution
 * @date 2021/10/10 10:16
 */
public class Question3Solution {
    public static void main(String[] args) {
        Question3Solution solution = new Question3Solution();
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());
    }

    static class MyCircularDeque {
        private final int capacity;
        private final int[] array;
        private int front;
        private int end;
        private int size;

        public MyCircularDeque(int k) {
            capacity = k;
            size = 0;
            front = 0;
            end = 1;
            array = new int[k + 2];
        }

        // Time: O(1)
        // Space: O(1)
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            size++;
            array[front] = value;
            if (front > 0) {
                front--;
            } else {
                front = capacity + 1;
            }
            return true;
        }

        // Time: O(1)
        // Space: O(1)
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            size++;
            array[end] = value;
            if (end < capacity + 1) {
                end++;
            } else {
                end = 0;
            }
            return true;
        }

        // Time: O(1)
        // Space: O(1)
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            size--;
            if (front < capacity + 1) {
                front++;
            } else {
                front = 0;
            }
            return true;
        }

        // Time: O(1)
        // Space: O(1)
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            size--;
            if (end > 0) {
                end--;
            } else {
                end = capacity + 1;
            }
            return true;
        }

        // Time: O(1)
        // Space: O(1)
        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            int temp = front;
            if (temp < capacity + 1) {
                temp++;
            } else {
                temp = 0;
            }
            return array[temp];
        }

        // Time: O(1)
        // Space: O(1)
        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            int temp = end;
            if (temp > 0) {
                temp--;
            } else {
                temp = capacity + 1;
            }
            return array[temp];
        }

        // Time: O(1)
        // Space: O(1)
        public boolean isEmpty() {
            return size == 0;
        }

        // Time: O(1)
        // Space: O(1)
        public boolean isFull() {
            return size == capacity;
        }
    }
}
