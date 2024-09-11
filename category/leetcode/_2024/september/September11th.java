package category.leetcode._2024.september;

public class September11th {

    public int minBitFlips(final int start, final int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
