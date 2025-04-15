
public class Fibonacci {

    static int fibonacciRecusrion(int n) { // tc = 2 ^n
        if (n == 0 || n == 1)
            return n;

        return fibonacciRecusrion(n - 1) + fibonacciRecusrion(n - 2);
    }

    static int fibonacciDPMemoization(int n, int dp[]) { // top down
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != 0)
            return dp[n];

        dp[n] = fibonacciDPMemoization(n - 1, dp) + fibonacciDPMemoization(n - 2, dp);
        return dp[n];

    }

    static int fibonacciDPTabulation(int n) { // bottom - up
        if (n == 0 || n == 1)
            return n;

        int dp[] = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];

        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n + 1];
        System.out.println("Fibonaaci with out dp  " + fibonacciRecusrion(n));
        System.out.println(" Fibonaaci with Dp Memoization  " + fibonacciDPMemoization(n, dp));
        System.out.println("Fibonaaci with Dp Tabluation  " + fibonacciDPTabulation(n));
    }
}