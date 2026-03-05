package category.leetcode._2026.march;

public class March5th {

    public int minOperations(String s) {
        int cost10 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - '0' == i % 2) {
                cost10++;
            }
        }

        int cost01 = s.length() - cost10;

        return Math.min(cost10, cost01);
    }
}
