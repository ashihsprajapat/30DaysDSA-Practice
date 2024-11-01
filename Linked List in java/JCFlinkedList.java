import java.util.LinkedList;

public class JCFlinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        ll.remove(1);
        System.out.println(ll.get(1));
        System.out.println(ll);
    }
}
