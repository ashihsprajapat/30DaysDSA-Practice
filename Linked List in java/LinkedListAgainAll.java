public class LinkedListAgainAll {
    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode head = null;
    public static ListNode tail = null;

    public static ListNode addLast(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = tail = newNode;
            return head;
        }
        tail.next = newNode;
        return head;

    }

    public static void Print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        ListNode head = null;
        for (int i = 0; i < arr.length; i++) {
            head = addLast(head, arr[i]);
        }
        Print(head);
    }

}
