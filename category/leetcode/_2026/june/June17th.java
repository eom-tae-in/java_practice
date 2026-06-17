package category.leetcode._2026.june;

public class June17th {

    public char processStr(String s, long k) {
        long length = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                length = Math.max(0, length - 1);
            } else if (ch == '#') {
                length *= 2;
            } else if (ch == '%') {
            } else {
                length++;
            }
        }

        if (k >= length) {
            return '.';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char curr = s.charAt(i);

            if (curr == '*') {
                length += 1;
            } else if (curr == '#') {
                long half = length / 2;

                if (k >= half) {
                    k -= half;
                }

                length = half;
            } else if (curr == '%') {
                k = length - 1 - k;
            } else {
                if (k == length - 1) {
                    return curr;
                }

                length--;
            }
        }

        return '.';
    }
}
