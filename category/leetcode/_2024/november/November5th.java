package category.leetcode._2024.november;

public class November5th {

    public int minChanges(final String s) {
        int n = s.length();
        int answer = 0;

        for (int i = 0; i < n; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                answer++;
            }
        }

        return answer;
    }
}
