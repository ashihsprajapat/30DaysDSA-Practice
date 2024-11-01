import java.util.*;

import org.w3c.dom.Node;

public class asd {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("Empty");
            return;
        }
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static ListNode re() {
        LinkedList<ListNode> ll = new LinkedList<>();
        ll.addFirst(4);
        ll.addLast(5);
        return ll.get(1);

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        // print(head);

    }
}
