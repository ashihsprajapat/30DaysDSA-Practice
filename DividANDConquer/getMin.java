public class getMin {
    public static void Min(int arr[], int idx, int min) {
        if (idx == arr.length) {
            System.out.println(min);
            return;
        }
        if (arr[idx] < min) {
            min = arr[idx];
        }
        Min(arr, idx + 1, min);

    }

    public static void main(String[] args) {
        int arr[] = { 1, -5, 2, 9, 4, 3 };
        Min(arr, 0, Integer.MAX_VALUE);
    }
}
