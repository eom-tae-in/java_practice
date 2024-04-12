package category.leetcode._2024.April;

import java.util.LinkedList;

public class April12th {

    public String removeKdigits(final String num, final int k) {
        int digit = k;
        if (num.length() == digit) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < num.length(); ++i) {
            while (digit > 0 && !stack.isEmpty() && stack.getLast() > num.charAt(i)) {
                stack.pollLast();
                digit--;
            }
            stack.addLast(num.charAt(i));
        }

        while (digit-- > 0) {
            stack.pollLast();
        }

        for (final char c : stack) {
            if (c == '0' && stringBuilder.length() == 0) {
                continue;
            }
            stringBuilder.append(c);
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }
}
