package category.leetcode._2024.october;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class October31th {

    public long minimumTotalDistance(final List<Integer> robot, final int[][] factory) {
        Collections.sort(robot);
        int n = factory.length;
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        long[][][] memory = new long[robot.size()][n][robot.size()];

        return executeDP(0, 0, 0, robot, factory, memory);
    }

    private long executeDP(
            final int i,
            final int j,
            final int k,
            final List<Integer> robot,
            final int[][] factory,
            final long[][][] memory
    ) {
        if (i == robot.size()) {
            return 0;
        }
        if (j == factory.length) {
            return Long.MAX_VALUE / 2;
        }
        if (memory[i][j][k] != 0) {
            return memory[i][j][k];
        }

        long skipFactory = executeDP(i, j + 1, 0, robot, factory, memory);
        int factoryPosition = factory[j][0];
        int factoryLimit = factory[j][1];
        long useFactory = factoryLimit > k ? executeDP(i + 1, j, k + 1, robot, factory, memory) + Math.abs(
                factoryPosition - robot.get(i)) :
                Long.MAX_VALUE / 2;

        return memory[i][j][k] = Math.min(skipFactory, useFactory);
    }
}
