import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class SelectionActivity {
    // Its for sorted array base on end array
    public static int maxActivity(int[] start, int[] end) {
        int maxAct = 0, endLast = end[0];
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        maxAct = 1;

        for (int i = 1; i < start.length; i++) {
            if (start[i] >= endLast) {
                maxAct++;
                ans.add(i);
                endLast = end[i];
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + "   ");
        }
        System.out.println();
        return maxAct;
    }

    // It for not sorted Array
    public static int maxActvit2(int[] start, int end[]) {
        int maxAct = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < start.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][0] = end[i];
        }
        int endLast = activities[0][2];
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
        ans.add(activities[0][0]);
        maxAct = 1;
        for (int i = 1; i < start.length; i++) {
            if (activities[i][1] >= endLast) {
                maxAct++;
                ans.add(activities[i][0]);
                endLast = activities[i][2];
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + "   ");
        }
        System.out.println();

        return maxAct;
    }

    public static void main(String[] args) {
        int start[] = { 10, 12, 14 }, end[] = { 21, 13, 15 };
        System.out.println("Max Activity" + maxActvit2(start, end));
    }
}
