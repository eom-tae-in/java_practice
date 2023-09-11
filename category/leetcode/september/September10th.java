package category.leetcode.september;

public class September10th {

    public static int countOrders(int n) {
        final int modNum = 1_000_000_007;
        long answer = 1;
        for (int i = 2; i <= n; i++) {
            answer = answer * i * (2 * i - 1) % modNum;
        }
        return (int) answer;
    }
}
