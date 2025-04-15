import org.w3c.dom.Node;

public class problem18 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ->  ");
            temp = temp.next;
        }
        System.out.println("null ");
    }

    public static void insert(Node head, int data) {
        Node newNode = new Node(data);
        Node temp = head;
        int position = 0;
        while (temp.data < newNode.data && temp != null) {
            position++;
            temp = temp.next;
        }
        if (position == 0) {
            position = 1;
        }
        add(head, position, newNode);
    }

    private static void add(Node head, int position, Node newNode) {

        int size = size(head);
        Node temp = head;
        if (size == position) {
            while (temp != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            return;

        }

        for (int i = 1; i <= position; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    private static int size(Node head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = head.next = new Node(2);
        Node three = second.next = new Node(3);
        Node fourth = three.next = new Node(4);
        Node five = fourth.next = new Node(5);
        Node six = five.next = new Node(6);
        // six.next = three;
        insert(head, 7);
        print(head);

    }
}
