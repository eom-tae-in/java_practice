package category.leetcode._2026.january;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class January14th {

    public double separateSquares(int[][] squares) {
        List<Line> lines = new ArrayList<>();

        for (int[] square : squares) {
            int x = square[0];
            int y = square[1];
            int l = square[2];
            lines.add(new Line(y, x, x + l, 1));
            lines.add(new Line(y + l, x, x + l, -1));
        }

        lines.sort(Comparator.comparingLong((Line line) -> line.y));
        List<XLine> xLines = new ArrayList<>();
        double totalArea = 0.0;

        for (int i = 0; i < lines.size() - 1; i++) {
            update(xLines, lines.get(i));
            long h = lines.get(i + 1).y - lines.get(i).y;

            if (h > 0) {
                totalArea += getWidth(xLines) * h;
            }
        }

        double halfArea = totalArea / 2.0;
        double accumulateArea = 0.0;
        xLines.clear();

        for (int i = 0; i < lines.size() - 1; i++) {
            Line line = lines.get(i);
            update(xLines, line);
            long h = lines.get(i + 1).y - line.y;

            if (h > 0) {
                long w = getWidth(xLines);
                double currArea = w * h;

                if (accumulateArea + currArea >= halfArea) {
                    return line.y + (halfArea - accumulateArea) / w;
                }

                accumulateArea += currArea;
            }
        }

        return 0.0;
    }

    private long getWidth(List<XLine> xLines) {
        if (xLines.isEmpty()) {
            return 0;
        }

        xLines.sort(Comparator.comparingLong((XLine xLine) -> xLine.start));
        long totalWidth = 0;
        long start = xLines.get(0).start;
        long end = xLines.get(0).end;

        for (int i = 1; i < xLines.size(); i++) {
            XLine xLine = xLines.get(i);

            if (xLine.start > end) {
                totalWidth += end - start;
                start = xLine.start;
                end = xLine.end;
            } else {
                end = Math.max(end, xLine.end);
            }
        }

        totalWidth += end - start;

        return totalWidth;
    }

    private void update(List<XLine> xLines, Line line) {
        if (line.status == 1) {
            xLines.add(new XLine(line.xStart, line.xEnd));
        } else {
            for (int i = 0; i < xLines.size(); i++) {
                XLine xLine = xLines.get(i);

                if (xLine.start == line.xStart && xLine.end == line.xEnd) {
                    xLines.remove(i);
                    break;
                }
            }
        }
    }

    private static class XLine {
        private final long start;
        private final long end;

        private XLine(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Line {
        private final long y;
        private final long xStart;
        private final long xEnd;
        private final int status;

        private Line(long y, long xStart, long xEnd, int status) {
            this.y = y;
            this.xStart = xStart;
            this.xEnd = xEnd;
            this.status = status;
        }
    }
}
