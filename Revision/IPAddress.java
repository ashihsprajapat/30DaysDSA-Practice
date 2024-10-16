public class IPAddress {
    public static String Ip(String ans) {
        String ans2 = "";
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) == '.') {
                ans2 += "[.]";
            } else {
                ans2 += ans.charAt(i);
            }

        }
        return ans2;
    }

    public static long revers(int nums) {
        String str = Integer.toString(nums);
        StringBuilder ans = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) { // Use str.length() here
            if (str.charAt(i) == '3') { // Use character '3' instead of integer 3
                ans.append("99");
            } else {
                ans.append(str.charAt(i));
            }
        }
        long ans2 = Long.parseLong(ans.toString());
        return ans2;

    }

    public static void main(String[] args) {
        String ans = "1.1.1.1";
        System.out.println(ans);
        System.out.println(Ip(ans));
        int nums = 1235353;
        System.out.println(nums);
        System.out.println(revers(nums));
    }
}