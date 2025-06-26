package category.leetcode._2025.june;

public class June26th {

    public int longestSubsequence(String s, int k) {
        int sLength = s.length();
        int count = 0;
        long pow = 1;
        long sum = 0;

        for (int i = sLength - 1; i >= 0 && sum + pow <= k; i--) {
            if (s.charAt(i) == '1') {
                sum += pow;
                count++;

            }

            pow *= 2;
        }

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }

        return count;
    }
}
