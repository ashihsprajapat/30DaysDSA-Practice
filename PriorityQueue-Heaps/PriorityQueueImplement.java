import java.util.PriorityQueue;
import java.util.Comparator;

public class PriorityQueueImplement {
    public static class Student implements Comparable<Student> {
        int marks;
        String Name;

        public Student(int m, String N) {
            this.marks = m;
            this.Name = N;
        }

        @Override
        public int compareTo(Student s2) {
            return this.marks - s2.marks;

        }
    }

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(2);
        pq.add(3);
        pq.add(5);
        pq.add(1);
        pq.add(0);
        pq.add(-1);
        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + "    ");
            pq.remove();
        }
        PriorityQueue<Student> pq2 = new PriorityQueue<>();
        pq2.add(new Student(86, "Ashish"));
        pq2.add(new Student(83, "Vishanu"));
        pq2.add(new Student(76, "Dinesh"));
        pq2.add(new Student(23, "Kartik"));
        pq2.add(new Student(45, "Palak"));
        pq2.add(new Student(96, "Vikash"));
        while (!pq2.isEmpty()) {
            System.out.print((pq2.peek()).Name + "-" + (pq2.peek()).marks + "    ");
            pq2.remove();
        }

    }
}