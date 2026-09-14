package category.leetcode._2026.september;

public class September14th {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int overlapWidth = Math.min(rec1[2], rec2[2]) - Math.max(rec1[0], rec2[0]);
        int overlapHeight = Math.min(rec1[3], rec2[3]) - Math.max(rec1[1], rec2[1]);

        return overlapWidth > 0 && overlapHeight > 0;
    }
}
