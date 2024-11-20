package category.leetcode._2024.november;

public class November20th {

    public int takeCharacters(final String s, final int k) {
        int[] count = new int[3];
        int n = s.length();
        int answer = n;

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        for (int left = 0, right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']--;
            while (count[s.charAt(right) - 'a'] < k) {
                count[s.charAt(left) - 'a']++;
                left++;
            }
            answer = Math.min(answer, n - (right - left + 1));
        }

        return answer;
    }
}
