package category.leetcode._2026.march;

public class March6th {

    public boolean checkOnesSegment(String s) {
        boolean seenZero = false;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (seenZero) {
                    return false;
                }
            } else {
                seenZero = true;
            }
        }

        return true;
    }
}
