package category.leetcode._2026.april;

public class April15th {

    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int answer = n;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int diff = Math.abs(i - startIndex);
                int dist = Math.min(diff, n - diff);
                answer = Math.min(answer, dist);
            }
        }

        return answer == n ? -1 : answer;
    }
}
