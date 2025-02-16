package category.leetcode._2025.february;

public class February16th {

    public int[] constructDistancedSequence(final int n) {
        int[] answer = new int[2 * n - 1];
        dfs(n, 0, 0, answer);

        return answer;
    }

    private boolean dfs(
            final int n,
            final int i,
            final int mask,
            final int[] answer
    ) {
        if (i == answer.length) {
            return true;
        }

        if (answer[i] > 0) {
            return dfs(n, i + 1, mask, answer);
        }

        for (int num = n; num >= 1; --num) {
            if ((mask >> num & 1) == 1) {
                continue;
            }
            if (num == 1) {
                answer[i] = num;
                if (dfs(n, i + 1, mask | 1 << num, answer)) {
                    return true;
                }
            } else {
                if (i + num >= answer.length || answer[i + num] > 0) {
                    continue;
                }
                answer[i] = num;
                answer[i + num] = num;
                if (dfs(n, i + 1, mask | 1 << num, answer)) {
                    return true;
                }
                answer[i + num] = 0;
            }
            answer[i] = 0;
        }

        return false;
    }
}
