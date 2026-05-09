package category.leetcode._2026.may;

import java.util.ArrayList;
import java.util.List;

public class May9th {

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int bottom = m - 1 - layer;
            int right = n - 1 - layer;
            List<Integer> list = new ArrayList<>();

            for (int j = layer; j <= right; j++) {
                list.add(grid[layer][j]);
            }

            for (int i = layer + 1; i < bottom; i++) {
                list.add(grid[i][right]);
            }

            for (int j = right; j >= layer; j--) {
                list.add(grid[bottom][j]);
            }

            for (int i = bottom - 1; i > layer; i--) {
                list.add(grid[i][layer]);
            }

            int len = list.size();
            int shift = k % len;
            List<Integer> rotated = new ArrayList<>(len);

            for (int i = 0; i < len; i++) {
                rotated.add(list.get((i + shift) % len));
            }

            int idx = 0;

            for (int j = layer; j <= right; j++) {
                grid[layer][j] = rotated.get(idx++);
            }

            for (int i = layer + 1; i < bottom; i++) {
                grid[i][right] = rotated.get(idx++);
            }

            for (int j = right; j >= layer; j--) {
                grid[bottom][j] = rotated.get(idx++);
            }

            for (int i = bottom - 1; i > layer; i--) {
                grid[i][layer] = rotated.get(idx++);
            }
        }

        return grid;
    }
}
