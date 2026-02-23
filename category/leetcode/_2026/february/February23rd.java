package category.leetcode._2026.february;

public class February23rd {

    public boolean hasAllCodes(String s, int k) {
        int sLen = s.length();
        int n = 1 << k;

        if (sLen < n - k + 1) {
            return false;
        }

        boolean[] visited = new boolean[n];
        int mask = 0;
        int allOnes = n - 1;
        int count = 0;

        for (int i = 0; i < sLen; i++) {
            mask = ((mask << 1) & allOnes) | s.charAt(i) - '0';

            if (i >= k - 1 && !visited[mask]) {
                visited[mask] = true;
                count++;

                if (count == n) {
                    return true;
                }
            }
        }

        return false;
    }
}
