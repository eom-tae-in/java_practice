package category.leetcode._2026.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class January13th {

    public double separateSquares(int[][] squares) {
        double halfArea = Arrays.stream(squares).mapToDouble(square -> Math.pow(square[2], 2)).sum() / 2;
        List<Line> lines = new ArrayList<>();

        for (int[] square : squares) {
            int y = square[1];
            int l = square[2];
            lines.add(new Line(y, 1, l));
            lines.add(new Line(y + l, -1, l));
        }

        lines.sort(Comparator.comparingInt(line -> line.y));
        double accumulateArea = 0;
        long width = 0;
        int prevY = lines.get(0).y;

        for (Line line : lines) {
            double currArea = width * (line.y - prevY);

            if (currArea + accumulateArea >= halfArea) {
                return prevY + (halfArea - accumulateArea) / width;
            }

            accumulateArea += currArea;
            width += line.status * line.width;
            prevY = line.y;
        }

        return 0;
    }

    private static class Line {

        private final int y;
        private final int status;
        private final int width;

        private Line(int y, int status, int width) {
            this.y = y;
            this.status = status;
            this.width = width;
        }
    }
}
