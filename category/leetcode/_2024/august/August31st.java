package category.leetcode._2024.august;

public class August31st {

    public double maxProbability(
            final int n,
            final int[][] edges,
            final double[] succProb,
            final int start_node,
            final int end_node
    ) {
        double[] probs = new double[n];
        probs[start_node] = 1;
        for (int i = 0; i < n - 1; i++) {
            boolean change = false;
            for (int j = 0; j < edges.length; j++) {
                int src = edges[j][0];
                int dest = edges[j][1];
                double prob = succProb[j];
                if (probs[src] * prob > probs[dest]) {
                    probs[dest] = probs[src] * prob;
                    change = true;
                }
                if (probs[dest] * prob > probs[src]) {
                    probs[src] = probs[dest] * prob;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }

        return probs[end_node];
    }
}
