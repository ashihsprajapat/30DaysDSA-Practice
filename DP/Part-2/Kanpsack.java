public class Kanpsack {

    public static int kanpasack01(int val[], int wt[], int W, int idx) {

        if (idx == 0 || W == 0) {
            return 0;
        }

        if (wt[idx - 1] <= W) {
            int includeProfite = val[idx - 1] + kanpasack01(val, wt, W - wt[idx - 1], idx - 1);
            int excludeProfite = kanpasack01(val, wt, W, idx - 1);
            return Math.max(includeProfite, excludeProfite);
        } else {
            return kanpasack01(val, wt, W, idx - 1);
        }

    }

    public static void main(String args[]) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        System.out.println(kanpasack01(val, wt, W, val.length));
    }
}