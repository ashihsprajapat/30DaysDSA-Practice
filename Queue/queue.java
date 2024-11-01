import java.util.Queue;

public class queue {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public static class Queue {
        public static Node head;
        public static Node tail;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }
        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null && tail == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int remove() {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int front = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
            }
            return front;
        }
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty");
                return Integer.MIN_VALUE;
            }
            return head.data;
        }

    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
            ;
        }

    }
}
