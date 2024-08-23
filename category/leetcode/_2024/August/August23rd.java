package category.leetcode._2024.August;

public class August23rd {

    public String fractionAddition(final String expression) {
        int num = 0;
        int denominator = 1;
        int index = 0;
        while (index < expression.length()) {
            int currNum = 0;
            int currDenom = 0;
            boolean isNegative = false;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                if (expression.charAt(index) == '-') {
                    isNegative = true;
                }
                index++;
            }
            while (Character.isDigit(expression.charAt(index))) {
                int val = expression.charAt(index) - '0';
                currNum = currNum * 10 + val;
                index++;
            }
            if (isNegative) {
                currNum *= -1;
            }
            index++;
            while (
                    index < expression.length() &&
                            Character.isDigit(expression.charAt(index))
            ) {
                int val = expression.charAt(index) - '0';
                currDenom = currDenom * 10 + val;
                index++;
            }
            num = num * currDenom + currNum * denominator;
            denominator = denominator * currDenom;
        }
        int gcd = Math.abs(FindGCD(num, denominator));
        num /= gcd;
        denominator /= gcd;

        return num + "/" + denominator;
    }

    private int FindGCD(final int a, final int b) {
        if (a == 0) {
            return b;
        }
        return FindGCD(b % a, a);
    }
}

