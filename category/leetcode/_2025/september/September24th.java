package category.leetcode._2025.september;

import java.util.HashMap;
import java.util.Map;

public class September24th {

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (numerator < 0 ^ denominator < 0) {
            stringBuilder.append("-");
        }

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);
        stringBuilder.append(n / d);

        if (n % d == 0) {
            return stringBuilder.toString();
        }

        stringBuilder.append(".");
        Map<Long, Integer> seen = new HashMap<>();

        for (long r = n % d; r > 0; r %= d) {
            if (seen.containsKey(r)) {
                stringBuilder.insert(seen.get(r), "(");
                stringBuilder.append(")");
                break;
            }

            seen.put(r, stringBuilder.length());
            r *= 10;
            stringBuilder.append(r / d);
        }

        return stringBuilder.toString();
    }
}
