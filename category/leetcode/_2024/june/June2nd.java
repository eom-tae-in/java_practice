package category.leetcode._2024.june;

public class June2nd {

    public void reverseString(final char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char leftValue = s[left];
            char rightValue = s[right];
            s[left++] = rightValue;
            s[right--] = leftValue;
        }
    }
}
