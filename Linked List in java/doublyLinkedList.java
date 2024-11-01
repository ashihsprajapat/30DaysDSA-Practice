public class doublyLinkedList {
    static class Node {
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

    // remove cycle group
    public static void removecycle(Node head) {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        slow = head;
        Node pre = null;
        while (slow != fast) {
            pre = fast;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = null;

    }

    public static void print(Node head) {
        if (head == null) {
            System.out.println("Empty Linked List ");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "  ->  ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = head.next.next;
        System.out.println(isCycle(head));
        removecycle(head);
        System.out.println(isCycle(head));
        print(head);

    }
}
