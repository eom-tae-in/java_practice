package category.leetcode._2025.september;

import java.util.PriorityQueue;
import java.util.Queue;

public class September1st {

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<Class> queue = new PriorityQueue<>();

        for (int[] c : classes) {
            queue.offer(new Class(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            Class c = queue.poll();
            queue.offer(new Class(c.pass + 1, c.total + 1));
        }

        return queue.stream()
                .map(c -> c.avg)
                .mapToDouble(Double::doubleValue)
                .sum() / queue.size();
    }

    private static class Class implements Comparable<Class> {

        private final int pass;
        private final int total;
        private final double avg;
        private final double increaseRatio;

        private Class(int pass, int total) {
            this.pass = pass;
            this.total = total;
            avg = (double) pass / total;
            increaseRatio = nextAvg() - avg;
        }

        private double nextAvg() {
            return (double) (pass + 1) / (total + 1);
        }

        @Override
        public int compareTo(Class other) {
            return Double.compare(other.increaseRatio, this.increaseRatio);
        }
    }
}
