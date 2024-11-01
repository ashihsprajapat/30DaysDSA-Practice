public class problem1 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Stack {
        public static Node head;
        public static Node tail;
        public static int size;

        public static void push(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;

        }

        public static int pop() {
            if (head == null) {
                return -1;
            }

            int data = head.data;
            head = head.next;

            return data;
        }

        public static int peek() {
            if (head == null) {
                return -1;
            }
            return head.data;
        }

        public static boolean isEmpty() {
            if (head == null) {
                return true;
            }
            return false;
        }
    }

    public static void main(String args[]) {
        // Implement stack using linked list
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());
        // System.out.println(s.pop());

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();

        }

    }
}