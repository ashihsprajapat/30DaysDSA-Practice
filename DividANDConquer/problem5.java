import java.util.HashMap;

public class problem5 {
    public static void MinMax(int arr[]) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> h = new HashMap<>();
        getMinMax(arr, 0, min, max, h);
    }

    private static void getMinMax(int arr[], int idx, int min, int max, HashMap<String, Integer> h) {
        if (idx == arr.length) {

            h.put("Min", min);
            h.put("Max", max);
            System.out.println("Min" + h.get("Min"));
            System.out.println("MAX" + h.get("Max"));
            return;
        }
        if (arr[idx] < min) {
            min = arr[idx];
        }
        if (arr[idx] > max) {
            max = arr[idx];
        }
        getMinMax(arr, idx + 1, min, max, h);

    }

    public static int getMax(String s, int x, int y) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == 'a' && s.charAt(i + 1) == 'b') {
                x++;
                i++;
            } else if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'b') {
                y++;
                i++;
            }
        }
        return Math.max(x, y);
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 9, 1, 8 };
        // MinMax(arr);
        String s = "cdbcbbaaabab";
        System.out.println(getMax(s, 0, 0));

    }
}