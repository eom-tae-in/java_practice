package category.leetcode._2025.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class December16th {

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        List<Integer>[] tree = new List[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] h : hierarchy) {
            int u = h[0] - 1;
            int v = h[1] - 1;
            tree[u].add(v);
        }

        State state = dfs(0, budget, present, future, tree);
        int answer = 0;

        for (int value : state.noParentBuy) {
            answer = Math.max(answer, value);
        }

        return answer;
    }

    private State dfs(int n, int budget, int[] present, int[] future, List<Integer>[] tree) {
        State curr = new State(budget);

        for (int child : tree[n]) {
            State childState = dfs(child, budget, present, future, tree);
            curr.parentBuy = merge(curr.parentBuy, childState.parentBuy, budget);
            curr.noParentBuy = merge(curr.noParentBuy, childState.noParentBuy, budget);
        }

        State next = new State(budget);

        int price = present[n];
        int profit = future[n] - price;

        for (int b = price; b <= budget; b++) {
            if (curr.parentBuy[b - price] != -1) {
                next.noParentBuy[b] = Math.max(next.noParentBuy[b], curr.parentBuy[b - price] + profit);
            }
        }

        int halfPrice = present[n] / 2;
        int halfProfit = future[n] - halfPrice;

        for (int b = halfPrice; b <= budget; b++) {
            if (curr.parentBuy[b - halfPrice] != -1) {
                next.parentBuy[b] = Math.max(next.parentBuy[b], curr.parentBuy[b - halfPrice] + halfProfit);
            }
        }

        for (int b = 0; b <= budget; b++) {
            next.noParentBuy[b] = Math.max(next.noParentBuy[b], curr.noParentBuy[b]);
            next.parentBuy[b] = Math.max(next.parentBuy[b], curr.noParentBuy[b]);
        }

        return next;
    }

    private int[] merge(int[] primary, int[] secondary, int budget) {
        int[] result = new int[budget + 1];

        for (int i = 0; i <= budget; i++) {
            if (primary[i] == -1) {
                continue;
            }

            for (int j = 0; j + i <= budget; j++) {
                if (secondary[j] == -1) {
                    continue;
                }

                result[i + j] = Math.max(result[i + j], primary[i] + secondary[j]);
            }
        }

        return result;
    }

    private static class State {

        private int[] parentBuy;
        private int[] noParentBuy;

        private State(int budget) {
            parentBuy = new int[budget + 1];
            noParentBuy = new int[budget + 1];
            Arrays.fill(parentBuy, -1);
            Arrays.fill(noParentBuy, -1);
            parentBuy[0] = 0;
            noParentBuy[0] = 0;
        }
    }
}
