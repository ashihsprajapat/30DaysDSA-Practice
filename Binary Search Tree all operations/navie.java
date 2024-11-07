public class navie {
    public static boolean isSunString(String t, String p) {
        for (int i = 0; i < t.length() - p.length(); i++) {
            int j;
            for (j = 0; j < p.length(); j++) {
                if (t.charAt(i + j) != p.charAt(j))
                    break;
            }
            if (j == p.length())
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String t = "AABAACAADAABAABA";
        String p = "AABAC";
        System.out.println(isSunString(t, p));
    }
}