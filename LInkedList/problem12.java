
public class problem12 {
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

    private static boolean isCycle(Node head) {
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

    public static void removeCycle(Node head) {
        if (head == null) {
            return;
        }
        Node slow = head;
        Node fast = head;
        boolean existCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                existCycle = true;
                break;
            }
        }
        if (existCycle == false) {
            return;
        }
        slow = head;
        Node temp = null;
        while (slow != fast) {
            temp = fast;
            fast = fast.next;
            slow = slow.next;

        }
        temp.next = null;

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = head.next = new Node(2);
        Node three = second.next = new Node(3);
        Node fourth = three.next = new Node(4);
        Node five = fourth.next = new Node(5);
        Node six = five.next = new Node(6);
        // six.next = three;
        removeCycle(head);
        if (isCycle(head) == false) {
            print(head);
        }
    }
}
