package category.leetcode._2024.may;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class May11th {

    public double mincostToHireWorkers(final int[] quality, final int[] wage, final int k) {
        Map<Efficiency, Integer> map = new HashMap<>();
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        double answer = Double.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < quality.length; i++) {
            map.put(new Efficiency((double) wage[i] / quality[i]), quality[i]);
        }

        List<Efficiency> efficiencies = new ArrayList<>(map.keySet());
        efficiencies.sort(Comparator.comparing(Efficiency::getValue));

        for (Efficiency efficiency : efficiencies) {
            double wagePerQuality = efficiency.getValue();
            int q = map.get(efficiency);
            sum += q;
            queue.offer(q);
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            if (queue.size() == k) {
                answer = Math.min(answer, sum * wagePerQuality);
            }
        }

        return answer;
    }
}

class Efficiency {

    private final double value;

    Efficiency(final double value) {
        this.value = value;
    }

    double getValue() {
        return value;
    }
}
