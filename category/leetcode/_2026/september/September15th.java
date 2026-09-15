package category.leetcode._2026.september;

public class September15th {

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int[] odd = getOddPalindromeRadius(s);
        int[] even = getEvenPalindromeRadius(s);
        int answer = 0;
        int start = 0;

        while (start + k <= n) {
            if (isPalindrome(start, start + k - 1, odd, even)) {
                answer++;
                start += k;
            } else if (start + k < n && isPalindrome(start, start + k, odd, even)) {
                answer++;
                start += k + 1;
            } else {
                start++;
            }
        }

        return answer;
    }

    private boolean isPalindrome(
            int left,
            int right,
            int[] odd,
            int[] even
    ) {
        int length = right - left + 1;

        if (length % 2 == 1) {
            int center = (left + right) / 2;

            return odd[center] >= length / 2 + 1;
        }

        int center = (left + right + 1) / 2;

        return even[center] >= length / 2;
    }

    private int[] getOddPalindromeRadius(String s) {
        int n = s.length();
        int[] odd = new int[n];
        int left = 0;
        int right = -1;

        for (int i = 0; i < n; i++) {
            int radius = i > right ? 1 : Math.min(odd[left + right - i], right - i + 1);

            while (i - radius >= 0 && i + radius < n && s.charAt(i - radius) == s.charAt(i + radius)) {
                radius++;
            }

            odd[i] = radius;

            if (i + radius - 1 > right) {
                left = i - radius + 1;
                right = i + radius - 1;
            }
        }

        return odd;
    }

    private int[] getEvenPalindromeRadius(String s) {
        int n = s.length();
        int[] even = new int[n];
        int left = 0;
        int right = -1;

        for (int i = 0; i < n; i++) {
            int radius = i > right ? 0 : Math.min(even[left + right - i + 1], right - i + 1);

            while (i - radius - 1 >= 0 && i + radius < n && s.charAt(i - radius - 1) == s.charAt(i + radius)) {
                radius++;
            }

            even[i] = radius;

            if (i + radius - 1 > right) {
                left = i - radius;
                right = i + radius - 1;
            }
        }

        return even;
    }
}
