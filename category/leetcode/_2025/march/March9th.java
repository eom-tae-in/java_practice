package category.leetcode._2025.march;

public class March9th {

    public int numberOfAlternatingGroups(final int[] colors, final int k) {
        int n = colors.length;
        int answer = 0;
        int alternating = 1;

        for (int i = 0; i < n + k - 2; i++) {
            alternating = colors[i % n] == colors[(i - 1 + n) % n] ? 1 : alternating + 1;
            if (alternating >= k) {
                answer++;
            }
        }

        return answer;
    }
}
