import java.util.*;

public class qued21 {

    class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode size1 = list1;
        int sz1 = 0;
        while (size1 != null) {
            size1 = size1.next;
            sz1++;
        }
        ListNode size2 = list2;
        int sz2 = 0;
        while (size2 != null) {
            size2 = size2.next;
            sz2++;
        }

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        for (int i = 0; i < (sz1 * 2) - 1; i++) {
            if (temp1 == null || temp2 == null) {
                break;
            }
            arr.add(temp1.data);
            i++;
            arr.add(temp2.data);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        ListNode merge = null;
        ListNode templast = merge;
        for (int i = 0; i < arr.size(); i++) {
            templast = new ListNode(arr.get(i));
            templast = templast.next;
        }
        return merge;

        // if (sz1 < sz2) {
        // for (int i = 0; i < sz2 - 1; i++) {
        // merge=list1;
        // merge.next=list2;
        // list1 = list1.next;
        // list2 = list2.next;
        // }
        // return ll;
        // } else {
        // for (int i = 0; i < sz1 - 1; i++) {
        // ll.addLast(list1);
        // ll.addLast(list2);
        // list1 = list1.next;
        // list2 = list2.next;
        // }
        // return ll;
        // }

    }

    public static void print(ListNode head) {

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode head = mergeTwoLists(list1, list2);
        print(head);
    }

}
