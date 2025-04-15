import java.util.Arrays;

public class LongestCommonSubsequence {

    public static String ans = "";

    public static int LCS(String str1, String str2, int n, int m) {
        // base case
        if (n == 0 || m == 0)
            return 0;

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            ans += str1.charAt(n - 1);
            return LCS(str1, str2, n - 1, m - 1) + 1;
        } else {
            int ans1 = LCS(str1, str2, n - 1, m);
            int ans2 = LCS(str1, str2, n, m - 1);
            return Math.max(ans1, ans2);
        }
    }

    public static int LCSMemoization(String str1, String str2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0)
            return 0;

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            ans += str1.charAt(n - 1);
            return dp[n][m] = LCSMemoization(str1, str2, n - 1, m - 1, dp) + 1;

        } else {
            int ans1 = LCSMemoization(str1, str2, n - 1, m, dp);
            int ans2 = LCSMemoization(str1, str2, n, m - 1, dp);
            return dp[n][m] = Math.max(ans1, ans2);

        }
    }

    public static void main(String[] args) {
        String str1 = "abcdge", str2 = "abedg";

        // System.out.println(LCS(str1, str2, str1.length(), str2.length()));
        // System.out.println(ans);
        // for memoization
        String strA = "abcde", strB = "ace";
        int n = strA.length(), m = strB.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        System.out.println(LCSMemoization(str1, str2, n, m, dp));
    }
}
