package category.leetcode._2026.january;

public class January17th {

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int minSide = 0;

        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int btx1 = bottomLeft[i][0];
                int bty1 = bottomLeft[i][1];
                int trx1 = topRight[i][0];
                int try1 = topRight[i][1];
                int btx2 = bottomLeft[j][0];
                int bty2 = bottomLeft[j][1];
                int trx2 = topRight[j][0];
                int try2 = topRight[j][1];
                int overlapX = Math.min(trx1, trx2) - Math.max(btx1, btx2);
                int overlapY = Math.min(try1, try2) - Math.max(bty1, bty2);
                minSide = Math.max(minSide, Math.min(overlapX, overlapY));
            }
        }

        return (long) minSide * minSide;
    }
}
