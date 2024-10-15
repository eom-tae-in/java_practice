package category.leetcode._2024.october;

public class October15th {

    public long minimumSteps(final String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        long answer = 0;
        while (left < right) {
            while (left < n && s.charAt(left) == '0') {
                left++;
            }

            while (right >= 0 && s.charAt(right) == '1') {
                right--;
            }

            if (right > left) {
                answer += right - left;
                right--;
                left++;
            }
        }

        return answer;
    }
}
