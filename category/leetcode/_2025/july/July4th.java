package category.leetcode._2025.july;

public class July4th {

    public char kthCharacter(long k, int[] operations) {
        int loopCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int count = 0;

        for (int i = loopCount - 1; i >= 0; i--) {
            long half = 1L << i;

            if (k > half) {
                k -= half;
                count += operations[i];
            }
        }

        return (char) ('a' + count % 26);
    }
}
