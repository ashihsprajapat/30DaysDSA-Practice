package SortingDay2;

public class SelectionSort {
    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    minIdx = j;
                }
            }
            // swapping to i and minIdx
            // arr[i] = arr[i] + arr[minIdx];
            // arr[minIdx] = arr[i] - arr[minIdx];
            // arr[i] = arr[i] - arr[minIdx];
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 9, 3, 1, 0, 4, 2, 6, 8 };
        print(arr);
        selectionSort(arr);
        print(arr);
    }
}
