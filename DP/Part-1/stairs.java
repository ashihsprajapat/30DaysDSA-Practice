import java.util.ArrayList;

public class stairs {

    public static int stairsCount(int n, ArrayList<Integer>[] dp) {
        // Initialize the dp array with the base cases
        ArrayList<Integer> base = new ArrayList<>();
        base.add(0); // Base case for step 0
        dp[0].add(new ArrayList<>(base)); // Add base case to dp[0]

        base = new ArrayList<>();
        base.add(1); // Base case for step 1
        dp[1].add(new ArrayList<>(base)); // Add base case to dp[1]

        // Populate dp array for steps 2 to n-1
        for (int i = 2; i < n; i++) {
            // Add ways from dp[i-1] (i-1 step)
            for (int k = 0; k < dp[i - 1].size(); k++) {
                ArrayList<Integer> newWay = new ArrayList<>(dp[i - 1].get(k)); // Copy the previous path
                newWay.add(1); // Add a step of 1
                dp[i].add(newWay); // Add the new way to dp[i]
            }

            // Add ways from dp[i-2] (i-2 steps)
            for (int k = 0; k < dp[i - 2].size(); k++) {
                ArrayList<Integer> newWay = new ArrayList<>(dp[i - 2].get(k)); // Copy the previous path
                newWay.add(2); // Add a step of 2
                dp[i].add(newWay); // Add the new way to dp[i]
            }
        }

        // Return the number of different ways to reach step n-1
        return dp[n - 1].size();
    }

    public static void print(ArrayList<Integer>[] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(i + "th stairs way is");
            for (ArrayList<Integer> path : dp[i]) {
                System.out.print(path + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7;

        // Initialize dp array of ArrayLists
        ArrayList<Integer>[] dp = new ArrayList[n];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new ArrayList<>();
        }

        // Get the total number of ways to reach step n-1
        int ans = stairsCount(n, dp);
        System.out.println("Total number of ways to reach step " + (n - 1) + ": " + ans);

        // Optionally print the ways to reach each step
        print(dp);
    }
}
