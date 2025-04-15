import java.security.PublicKey;
import java.util.LinkedList;

public class problemNo2 {
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

    public static Node findnthNode(Node head, int n) {
        if (head == null) {
            return null;
        }
        int size = size(head);
        int max = size - n;
        Node temp = head;
        for (int i = 0; i < max; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // solve by recursively
    private static int counter = 0;

    public static Node findNNode(Node head, int n) {
        if (head != null) {
            // int counter = 0;
            findNNode(head.next, n);
            counter++;
            if (counter == n) {
                return head;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        Node second = head.next = new Node(2);
        Node three = second.next = new Node(3);
        Node fourth = three.next = new Node(4);
        print(head);
        System.out.println(findnthNode(head, 2).data);
        System.out.println(findNNode(head, 2));

    }
}