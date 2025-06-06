package category.leetcode._2025.june;

import java.util.ArrayDeque;
import java.util.Deque;

public class June6th {

    public String robotWithString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] count = new int[26];
        int sLength = s.length();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < sLength; i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sLength; i++) {
            char current = s.charAt(i);
            stack.push(current);
            count[current - 'a']--;
            char min = getMinChar(count);

            while (!stack.isEmpty() && stack.peek() <= min) {
                stringBuilder.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

    private char getMinChar(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                return (char) ('a' + i);
            }
        }

        return 'a';
    }
}
