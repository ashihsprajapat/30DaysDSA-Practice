public class creatLInkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;

    // add First Operation
    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;

    }

    // add last opeartion
    public static void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;

    }

    

    // add at Index
    public static void add(int idx, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // size claculate
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == idx) {
            addLast(data);
        }
        Node pre = head;
        // find pre node
        for (int i = 0; i < idx - 2; i++) {
            pre = pre.next;
        }
        newNode.next = pre.next;
        pre.next = newNode;
    }

    // remove First operation
    public static int removeFirst() {
        if (head == null) {
            System.out.println("Empty Linked List ");
            return -1;
        }
        int val = head.data;
        head = head.next;
        return val;
    }

    // remove Last Opeartion
    public static int removeLast() {
        if (head == null) { // base case
            System.out.println("Empty Linked List ");
            return -1;
        }
        // size claculate
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (sz == 1) {
            int val = head.data;
            head = tail = null;
            return val;

        }
        // terack pre node
        Node pre = head;
        for (int i = 0; i < sz - 2; i++) {
            pre = pre.next;
        }
        int val = tail.data;
        pre.next = null; // tail
        tail = pre;
        return val;
    }

    // remove at index
    public static int remove(int idx) {
        if (head == null) {
            return -1;
        }
        // size calculate
        Node size = head;
        int sz = 0;
        while (size != null) {
            size = size.next;
            sz++;
        }
        if (sz == 1) { // remove head
            int val = head.data;
            head = head.next;
            return val;
        }
        if (sz == idx) { // remove last element
            int val = tail.data;
            Node pre = head;
            for (int i = 0; i < sz - 2; i++) {
                pre = pre.next;
            }
            pre.next = null;
            tail = pre;
            return val;
        }
        // find pre of remove element
        Node temp = head;
        for (int i = 0; i < idx - 2; i++) {
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        return val;
    }

    // print operation
    public static void print() {
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

    // Eterative search
    public static boolean Eterative(int val) {
        if (head == null) {
            return false;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // recursive search
    public static int Recursive(int val) {
        return helper(head, val);
    }

    public static int helper(Node head, int val) {
        if (head == null) {
            return -1;
        }
        if (head.data == val) {
            return 0;
        }
        int re = helper(head.next, val);
        if (re == -1) {
            return -1;
        }

        return re + 1;

    }

    // revers linked list
    public static void revers() {
        Node pre = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
            head = pre;
        }
    }

    public static void main(String[] args) {

        print();
        addFirst(4);
        addFirst(3);
        addFirst(2);
        addFirst(1);

        addLast(5);
        addLast(6);
        add(5, 10);
        print();
        System.out.println("delet  value    " + remove(5));

        print();
        revers();
        print();
        System.out.println(Eterative(1));
        System.out.println(Recursive(1));

    }
}