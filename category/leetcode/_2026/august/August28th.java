package category.leetcode._2026.august;

public class August28th {

    private static final int ALPHABET_SIZE = 26;
    private static final char NO_MIDDLE = 0;

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int halfLength = n / 2;
        int[] halfCount = new int[ALPHABET_SIZE];

        for (int i = 0; i < n; i++) {
            halfCount[s.charAt(i) - 'a']++;
        }

        int oddCount = 0;
        char middle = NO_MIDDLE;

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if ((halfCount[i] & 1) == 1) {
                oddCount++;
                middle = (char) ('a' + i);
            }

            halfCount[i] /= 2;
        }

        if (oddCount > 1) {
            return "";
        }

        StringBuilder left = new StringBuilder(halfLength);
        int index = 0;

        while (index < halfLength) {
            int current = target.charAt(index) - 'a';

            if (halfCount[current] == 0) {
                break;
            }

            left.append((char) ('a' + current));
            halfCount[current]--;
            index++;
        }

        if (index == halfLength) {
            if (isPalindromeGreater(left, middle, target)) {
                return buildPalindrome(left, middle);
            }
        } else {
            int current = target.charAt(index) - 'a';
            int larger = findNextLarger(halfCount, current);

            if (larger != -1) {
                left.append((char) ('a' + larger));
                halfCount[larger]--;
                appendRemainingAscending(left, halfCount);

                return buildPalindrome(left, middle);
            }
        }

        while (!left.isEmpty()) {
            int lastIndex = left.length() - 1;
            int removed = left.charAt(lastIndex) - 'a';
            left.setLength(lastIndex);
            halfCount[removed]++;
            int larger = findNextLarger(halfCount, removed);

            if (larger != -1) {
                left.append((char) ('a' + larger));
                halfCount[larger]--;
                appendRemainingAscending(left, halfCount);

                return buildPalindrome(left, middle);
            }
        }

        return "";
    }

    private int findNextLarger(int[] halfCount, int current) {
        for (int i = current + 1; i < ALPHABET_SIZE; i++) {
            if (halfCount[i] > 0) {
                return i;
            }
        }

        return -1;
    }

    private void appendRemainingAscending(StringBuilder left, int[] halfCount) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            char current = (char) ('a' + i);
            left.append(String.valueOf(current).repeat(Math.max(0, halfCount[i])));
        }
    }

    private String buildPalindrome(StringBuilder left, char middle) {
        int totalLength = left.length() * 2;

        if (middle != NO_MIDDLE) {
            totalLength++;
        }

        StringBuilder palindrome = new StringBuilder(totalLength);
        palindrome.append(left);

        if (middle != NO_MIDDLE) {
            palindrome.append(middle);
        }

        for (int i = left.length() - 1; i >= 0; i--) {
            palindrome.append(left.charAt(i));
        }

        return palindrome.toString();
    }

    private boolean isPalindromeGreater(StringBuilder left, char middle, String target) {
        int halfLength = left.length();
        int index = halfLength;

        if (middle != NO_MIDDLE) {
            char targetMiddle = target.charAt(index);

            if (middle != targetMiddle) {
                return middle > targetMiddle;
            }

            index++;
        }

        for (int i = halfLength - 1; i >= 0; i--, index++) {
            char current = left.charAt(i);
            char targetChar = target.charAt(index);

            if (current != targetChar) {
                return current > targetChar;
            }
        }

        return false;
    }
}
