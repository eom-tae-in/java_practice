package category.leetcode._2024.June;

public class June21st {

    public int maxSatisfied(final int[] customers, final int[] grumpy, final int minutes) {
        int n = customers.length;
        int satisfied = 0;
        int currentUnSatisfied = 0;
        int cumulativeMadeMaxSatisfied = Integer.MIN_VALUE;
        int minuteCount = 0;
        int index = -1;
        while (++index < n) {
            minuteCount++;
            int customer = customers[index];
            if (grumpy[index] == 0) {
                satisfied += customer;
            } else {
                currentUnSatisfied += customer;
            }
            if (minuteCount == minutes) {
                cumulativeMadeMaxSatisfied = Math.max(cumulativeMadeMaxSatisfied, currentUnSatisfied);
                int leftIndex = index - minutes + 1;
                if (grumpy[leftIndex] == 1) {
                    currentUnSatisfied -= customers[leftIndex];
                }
                minuteCount--;
            }
        }

        return cumulativeMadeMaxSatisfied + satisfied;
    }
}
