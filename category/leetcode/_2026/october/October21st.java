package category.leetcode._2026.october;

public class October21st {

    public int minOperations(String s) {
        int n = s.length();
        boolean isSorted = true;
        char max = s.charAt(0);
        char min = s.charAt(0);

        for (int i = 1; i < n; i++) {
            char curr = s.charAt(i);

            if (curr < s.charAt(i - 1)) {
                isSorted = false;
            }

            if (curr < min) {
                min = curr;
            }

            if (curr > max) {
                max = curr;
            }
        }

        if (isSorted) {
            return 0;
        }

        if (n <= 2) {
            return -1;
        }

        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            char curr = s.charAt(i);

            if (curr == min || curr == max) {
                return 2;
            }
        }

        return 3;
    }
}
