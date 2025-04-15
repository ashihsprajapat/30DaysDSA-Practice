
public class problem15 {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
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

    public static int length(Node head) {
        if (head == null) {
            return Integer.MIN_VALUE;
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
        Node temp = null;
        int length = 0;
        if (existCycle == true) {
            slow = head;

            while (slow != fast) {
                temp = fast;
                slow = slow.next;
                fast = fast.next;
            }
            Node move = head;
            while (move != temp) {
                length++;
                move = move.next;
            }
            return length + 1;
        } else {
            Node move = head;
            while (move != null) {
                length++;
                move = move.next;
            }
            return length;
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

    public static void main(String[] args) {
        Node head = new Node(1);
        Node second = head.next = new Node(2);
        Node three = second.next = new Node(3);
        Node fourth = three.next = new Node(4);
        Node five = fourth.next = new Node(5);
        Node six = five.next = new Node(6);
        // six.next = three;
        System.out.println(length(head));
        if (isCycle(head) == false) {
            print(head);
        }
    }
}
