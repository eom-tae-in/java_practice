package category.leetcode._2026.september;

public class September9th {

    public long countCommas(long n) {
        long answer = 0;
        answer += Math.max(0, n - 999);
        answer += Math.max(0, n - 999_999);
        answer += Math.max(0, n - 999_999_999);
        answer += Math.max(0L, n - 999_999_999_999L);
        answer += Math.max(0L, n - 999_999_999_999_999L);

        return answer;
    }
}
