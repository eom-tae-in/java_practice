package category.leetcode._2026.november;

public class November11th {

    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long common = Math.min(need1, need2);
        long commonCost = common * Math.min(cost1 + cost2, costBoth);
        long remaining1 = (long) need1 - common;
        long remaining2 = (long) need2 - common;
        long remainingCost = remaining1 * Math.min(cost1, costBoth) + remaining2 * Math.min(cost2, costBoth);

        return commonCost + remainingCost;
    }
}
