public class ClimbingStairs {

    public static int stairsCountWay(int stairs) {
        int dp[] = new int[stairs + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < stairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[stairs - 1];
    }

    public static int countWay(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return countWay(n - 1) + countWay(n - 2);
    }

    public static void main(String[] args) {
        int stairs = 4;
        System.out.println("no of way without sp   " + countWay(stairs));
        // System.out.println("Number of way to react stairs " +
        // stairsCountWay(stairs));
    }
}
