package category.leetcode._2024.february;

public class February22nd {

    public int findJudge(final int n, final int[][] trust) {
        int[] count = new int[n + 1];

        for (int[] currentTrust : trust) {
            count[currentTrust[0]]--;
            count[currentTrust[1]]++;
        }

        for (int i = 1; i < n + 1; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }
}
