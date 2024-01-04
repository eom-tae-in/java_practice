package category.leetcode._2023.september;

public class September27th {

    public String decodeAtIndex(String s, int k) {
        long size = 0;
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                size *= ch - '0';
            } else {
                size++;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            k %= size;
            char currentChar = s.charAt(i);
            if (k == 0 && Character.isAlphabetic(currentChar)) {
                return s.substring(i, i + 1);
            }
            if (Character.isDigit(currentChar)) {
                size /= currentChar - '0';
            } else {
                size--;
            }
        }
        throw new IllegalArgumentException();
    }
}
