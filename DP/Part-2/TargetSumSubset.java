public class TargetSumSubset {
    public static boolean tabulatiobSum(int number[], int sum) {
        int n = number.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int v = number[i - 1];
                // inclued
                if (v <= j && dp[i - 1][j - v] == true) {
                    dp[i][j] = true;
                }
                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][sum];

    }

    public static void main(String[] args) {
        int number[] = { 4, 2, 7, 1, 3 };
        int sum = 17;
        System.err.println(tabulatiobSum(number, sum));
    }
}
