public class BackOnArray {
    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "   ");
        }
        System.out.println();
    }

    public static void BackTrack(int arr[], int i) {
        if (i == arr.length) {
            print(arr);
            return;
        }
        BackTrack(arr, i + 1);
        arr[i] = arr[i] - 2;
    }

    public static int Factorial(int i) {
        if (i == 1) {
            return 1;
        }
        int fact = 1;
        fact = i * Factorial(i - 1);
        fact = fact + 1;
        return fact;

    }

    public static void sebSet(String str, String ans, int i) {
        if (i == str.length()) {
            System.out.print(ans + ",   ");
            return;
        }
        sebSet(str, ans + str.charAt(i), i + 1);

        sebSet(str, ans, i + 1);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        // BackTrack(arr, 0);
        // print(arr);
        // System.out.println(Factorial(3));
        String str = "abc";
        sebSet(str, "", 0);

    }
}