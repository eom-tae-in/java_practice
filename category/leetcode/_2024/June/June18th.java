package category.leetcode._2024.June;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class June18th {

    public int maxProfitAssignment(final int[] difficulty, final int[] profit, final int[] worker) {
        Queue<Work> minDifficulty = new PriorityQueue<>(Comparator.comparingInt(Work::getDifficulty));
        int answer = 0;
        int n = difficulty.length;
        for (int i = 0; i < n; i++) {
            minDifficulty.offer(new Work(difficulty[i], profit[i]));
        }

        Arrays.sort(worker);
        Queue<Work> maxProfit = new PriorityQueue<>((a, b) -> b.getProfit() - a.getProfit());
        for (int ability : worker) {
            while (!minDifficulty.isEmpty() && ability >= minDifficulty.peek().getDifficulty()) {
                maxProfit.offer(minDifficulty.poll());
            }

            if (!maxProfit.isEmpty()) {
                answer += maxProfit.peek().getProfit();
            }
        }

        return answer;
    }
}

class Work {

    private final int difficulty;
    private final int profit;

    Work(final int difficulty, final int profit) {
        this.difficulty = difficulty;
        this.profit = profit;
    }

    int getDifficulty() {
        return difficulty;
    }

    int getProfit() {
        return profit;
    }
}

