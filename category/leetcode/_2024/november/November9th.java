package category.leetcode._2024.november;

public class November9th {

    public long minEnd(final int n, final int x) {
        int bitMaxLength = getBitLength(n) + getBitLength(x);
        long answer = x;
        int numsLength = n - 1;
        int numsIndex = 0;
        int numsBitLength = getBitLength(numsLength);

        for (int i = 0; i < bitMaxLength; i++) {
            if ((answer >> i & 1) == 0) {
                if ((numsLength >> numsIndex & 1) == 1) {
                    answer |= 1L << i;
                }
                numsIndex++;
            }

            if (numsIndex == numsBitLength) {
                break;
            }
        }

        return answer;
    }

    private int getBitLength(final int num) {
        return 32 - Integer.numberOfLeadingZeros(num);
    }
}
