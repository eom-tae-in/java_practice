package category.leetcode._2026.june;

public class June19th {

    public int largestAltitude(int[] gain) {
        int status = 0;
        int answer = 0;

        for (int g : gain) {
            status += g;
            answer = Math.max(answer, status);
        }

        return answer;
    }
}
