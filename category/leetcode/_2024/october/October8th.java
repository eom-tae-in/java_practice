package category.leetcode._2024.october;

public class October8th {

    public int minSwaps(final String s) {
        int unmatched = 0;

        for (final char c : s.toCharArray()) {
            if (c == '[') {
                unmatched++;
            } else if (unmatched > 0) {
                unmatched--;
            }
        }

        return (unmatched + 1) / 2;
    }
}
