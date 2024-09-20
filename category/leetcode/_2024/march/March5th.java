package category.leetcode._2024.march;

public class March5th {

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            int currentChar = s.charAt(left);
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            while (left <= right && s.charAt(right) == currentChar) {
                right--;
            }
        }

        return right - left + 1;
    }
}
