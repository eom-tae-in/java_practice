package category.leetcode._2026.november;

public class November26th {

    public boolean canAliceWin(int n) {
        int stonesToRemove = 10;
        boolean aliceTurn = true;

        while (stonesToRemove > 0 && n >= stonesToRemove) {
            n -= stonesToRemove;
            stonesToRemove--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}
