public class problem7 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static String problem11(Node head) {
        if (head == null) {
            return "";
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return "snail";
            }
        }
        return "snake";
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = head.next = new Node(2);
        Node three = second.next = new Node(3);
        Node fourth = three.next = new Node(4);
        Node five = fourth.next = new Node(6);
        Node six = five.next = new Node(6);
        six.next = three;
        System.out.println(isCycle(head));
        System.out.println(problem11(head));

    }
}
