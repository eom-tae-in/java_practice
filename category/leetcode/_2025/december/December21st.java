package category.leetcode._2025.december;

public class December21st {

    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int answer = 0;
        boolean[] sorted = new boolean[n - 1];

        for (int j = 0; j < strs[0].length(); j++) {
            int i;

            for (i = 0; i < n - 1; i++) {
                if (!sorted[i] && strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    answer++;
                    break;
                }
            }

            if (i == n - 1) {
                for (i = 0; i < n - 1; ++i) {
                    sorted[i] = sorted[i] || strs[i].charAt(j) < strs[i + 1].charAt(j);
                }
            }
        }

        return answer;
    }
}
