package category.leetcode._2024.november;

public class November6th {

    public boolean canSortArray(final int[] nums) {
        int bitCount = 0;
        int prevMax = Integer.MIN_VALUE;
        int currentMin = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;

        for (int current : nums) {
            int currentBitCount = Integer.bitCount(current);
            if (bitCount != currentBitCount) {
                if (prevMax > currentMin) {
                    return false;
                }
                bitCount = currentBitCount;
                prevMax = currentMax;
                currentMin = current;
                currentMax = current;
            } else {
                currentMax = Math.max(currentMax, current);
                currentMin = Math.min(currentMin, current);
            }
        }

        return prevMax < currentMin;
    }
}
