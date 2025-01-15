package category.leetcode._2025.january;

public class January15th {

    public int minimizeXor(final int num1, final int num2) {
        int maxBit = 30;
        int bits = Integer.bitCount(num2);
        int answer = 0;

        if (Integer.bitCount(num1) == bits) {
            return num1;
        }

        for (int i = maxBit - 1; i >= 0; i--) {
            if ((num1 >> i & 1) == 1) {
                answer |= 1 << i;
                bits--;
            }

            if (bits == 0) {
                return answer;
            }
        }

        for (int i = 0; i < maxBit; i++) {
            if ((num1 >> i & 1) == 0) {
                answer |= 1 << i;
                bits--;
            }

            if (bits == 0) {
                return answer;
            }
        }

        return answer;
    }
}
