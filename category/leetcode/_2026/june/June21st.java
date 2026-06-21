package category.leetcode._2026.june;

public class June21st {

    private static final int MAX_SIZE = 100_000;

    public int maxIceCream(int[] costs, int coins) {
        int[] count = new int[MAX_SIZE + 1];

        for (int cost : costs) {
            count[cost]++;
        }

        int answer = 0;

        for (int i = 1; i <= MAX_SIZE && coins > 0; i++) {
            if (count[i] == 0) {
                continue;
            }

            int buy = Math.min(count[i], coins / i);
            answer += buy;
            coins -= buy * i;
        }

        return answer;
    }
}
