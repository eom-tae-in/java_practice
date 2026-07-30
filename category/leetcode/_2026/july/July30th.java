package category.leetcode._2026.july;

public class July30th {

    public int minimumPushes(String word) {
        int n = word.length();
        int answer = 0;
        int currCount = 1;

        while (n > 0) {
            int min = Math.min(8, n);
            answer += currCount * min;
            n -= min;
            currCount++;
        }

        return answer;
    }
}
