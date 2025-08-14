package category.leetcode._2025.august;

public class August14th {

    public String largestGoodInteger(String num) {
        int max = -1;
        char prevPrev = num.charAt(0);
        char prev = num.charAt(1);
        int numLength = num.length();

        for (int i = 2; i < numLength; i++) {
            char current = num.charAt(i);

            if (prevPrev == prev && prev == current) {
                max = Math.max(max, current - '0');
            }

            prevPrev = prev;
            prev = current;
        }

        return max == -1 ? "" : String.valueOf(max).repeat(3);
    }
}
