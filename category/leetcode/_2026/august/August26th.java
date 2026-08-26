package category.leetcode._2026.august;

public class August26th {

    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        String answer = "";
        int currOneCount = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);

            if (curr == '1') {
                currOneCount++;
            }

            while (currOneCount > k) {
                if (s.charAt(left++) == '1') {
                    currOneCount--;
                }
            }

            while (left < right && s.charAt(left) == '0') {
                left++;
            }

            if (currOneCount == k) {
                String candidate = s.substring(left, right + 1);

                if (isBetter(candidate, answer)) {
                    answer = candidate;
                }
            }
        }

        return answer;
    }

    private boolean isBetter(String candidate, String answer) {
        return answer.isEmpty()
                || candidate.length() < answer.length()
                || (candidate.length() == answer.length() && candidate.compareTo(answer) < 0);
    }
}
