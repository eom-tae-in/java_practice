package category.leetcode._2026.june;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class June20th {

    public int maxBuilding(int n, int[][] restrictions) {
        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building(1, 0));

        for (int[] restriction : restrictions) {
            buildings.add(new Building(restriction[0], restriction[1]));
        }

        buildings.sort(Comparator.comparingInt((Building b) -> b.idx));

        if (buildings.get(buildings.size() - 1).idx != n) {
            buildings.add(new Building(n, n - 1));
        }

        for (int i = 1; i < buildings.size(); i++) {
            Building prev = buildings.get(i - 1);
            Building curr = buildings.get(i);
            curr.updateHeight(prev.height, curr.idx - prev.idx);
        }

        for (int i = buildings.size() - 2; i > 0; i--) {
            Building next = buildings.get(i + 1);
            Building curr = buildings.get(i);
            curr.updateHeight(next.height, next.idx - curr.idx);
        }

        int answer = 0;

        for (int i = 1; i < buildings.size(); i++) {
            Building prev = buildings.get(i - 1);
            Building curr = buildings.get(i);
            int currMax = (prev.height + curr.height + (curr.idx - prev.idx)) / 2;
            answer = Math.max(answer, currMax);
        }

        return answer;
    }

    private static class Building {

        private final int idx;
        private int height;

        private Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }

        private void updateHeight(int h, int dist) {
            this.height = Math.min(height, h + dist);
        }
    }
}
