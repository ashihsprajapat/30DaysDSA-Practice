import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class TopKElement {

    public static int[] TopK(int arr[], int k) { // int this method tc=O(nlogn) Sc=O(k);
        int result[] = new int[k];
        Arrays.sort(arr);

        // Reverse the array manually to get descending order
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static int[] TopK2(int arr[], int k) {// Total Tc=O(n)+O(k logn); Sc=O(n);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {// for inserting all element in pq that is Tc =O(n);
            pq.add(arr[i]);
        }
        int result[] = new int[k];
        for (int i = 0; i < k; i++) { // pop of pq tc=O(k logn);
            result[i] = pq.remove();
        }
        return result;
    }

    public static int[] TopK3(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        int result[] = new int[k];
        int idx = k - 1;
        while (!pq.isEmpty()) {
            result[idx] = pq.remove();
            idx--;
        }
        return result;
    }

    public static void main(String args[]) {
        int arr[] = { 5, 9, 3, 4, 8, 2 };
        int ans[] = TopK3(arr, 3);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + "  ");
        }
    }
}