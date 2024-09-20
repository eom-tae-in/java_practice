package category.leetcode._2024.june;

import java.util.PriorityQueue;
import java.util.Queue;

public class June15th {

    public int findMaximizedCapital(int k, int w, final int[] profits, final int[] capital) {
        Queue<Project> minCapital = new PriorityQueue<>((a, b) -> a.getCapital() - b.getCapital());
        Queue<Project> maxProfit = new PriorityQueue<>((a, b) -> b.getProfit() - a.getProfit());
        int n = profits.length;
        for (int i = 0; i < n; i++) {
            minCapital.offer(new Project(profits[i], capital[i]));
        }

        while (k-- > 0) {
            while (!minCapital.isEmpty() && minCapital.peek().getCapital() <= w) {
                maxProfit.offer(minCapital.poll());
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll().getProfit();
        }

        return w;
    }
}

class Project {

    private final int profit;
    private final int capital;

    Project(final int profit, final int capital) {
        this.profit = profit;
        this.capital = capital;
    }

    int getProfit() {
        return profit;
    }

    int getCapital() {
        return capital;
    }
}
