package category.leetcode._2025.november;

public class November13th {

    public int maxOperations(String s) {
        int answer = 0;
        int ones = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    answer += ones;
                }
            }
        }

        return answer;
    }
}
