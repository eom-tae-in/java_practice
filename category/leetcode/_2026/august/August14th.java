package category.leetcode._2026.august;

public class August14th {

    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int n = s.length();
        int answer = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            int currIdx = s.charAt(right) - 'a';
            count[currIdx]++;

            while (count[currIdx] > 2) {
                count[s.charAt(left++) - 'a']--;
            }

            answer = Math.max(answer, right - left + 1);
        }

        return answer;
    }
}
