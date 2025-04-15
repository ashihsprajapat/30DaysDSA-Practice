public class CoinChange {

    public static int coinChange(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n + 1][sum + 1];

        // asign value
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        // i -> coins idx
        // j -> sum
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                // chack valid
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDp(dp);

        return dp[n][sum];
    }

    public static void printDp(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println();
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5 };
        int sum = 11;
        System.out.println(coinChange(coins, sum));
    }
}
