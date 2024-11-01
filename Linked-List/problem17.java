
public class problem17 {
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
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "    ->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static Node revers(Node head) {
        if (head == null) {
            return null;
        }
        Node curr = head;
        Node prve = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prve;
            prve = curr;
            curr = next;
        }
        head = prve;
        return head;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);
        root.next.next.next.next.next.next = new Node(7);
        root.next.next.next.next.next.next.next = new Node(8);

        print(root);
        Node head = revers(root);
        print(head);
    }
}
