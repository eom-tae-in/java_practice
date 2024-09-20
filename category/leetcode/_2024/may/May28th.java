package category.leetcode._2024.may;

public class May28th {

    public int equalSubstring(final String s, final String t, int maxCost) {
        int left = 0;
        int right = 0;

        while (right < s.length()) {
            maxCost -= Math.abs(s.charAt(right) - t.charAt(right++));
            if (maxCost < 0) {
                maxCost += Math.abs(s.charAt(left) - t.charAt(left++));
            }
        }

        return right - left;
    }
}
