public class Problem2 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static int size(Node head) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            i++;
            temp = temp.next;
        }
        return i;
    }

    public static Node findnthNode(Node head, int nth) {
        int size = size(head);
        Node temp = head;
        int n = size - nth;
        for (int i = 0; i < n; i++) {
            temp = temp.next;

        }
        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = new Node(6);

        System.out.println(findnthNode(root, 4).data);
        ;

    }
}
