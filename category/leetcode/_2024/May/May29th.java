package category.leetcode._2024.May;

public class May29th {

    public int numSteps(final String s) {
        if (s.length() == 1) {
            return 0;
        }

        return s.charAt(s.length() - 1) == '1' ? 1 + numSteps(addOne(s)) : 1 + numSteps(divideByTwo(s));
    }

    private String addOne(final String s) {
        StringBuilder stringBuilder = new StringBuilder();
        if (calculateCarry(s, stringBuilder) == 1) {
            stringBuilder.append(1);
        }

        return stringBuilder.reverse()
                .toString();
    }

    private int calculateCarry(final String s, final StringBuilder stringBuilder) {
        int val = s.charAt(0) - '0';
        if (s.length() == 1) {
            stringBuilder.append(0);
            return 1;
        }

        val += calculateCarry(s.substring(1), stringBuilder);
        stringBuilder.append(val % 2);

        return val / 2;
    }

    private String divideByTwo(final String s) {
        return s.substring(0, s.length() - 1);
    }
}
