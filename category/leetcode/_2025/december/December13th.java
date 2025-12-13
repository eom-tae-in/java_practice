package category.leetcode._2025.december;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class December13th {

    private static final Map<String, Integer> SORT_ORDER = Map.of(
            "electronics", 0,
            "grocery", 1,
            "pharmacy", 2,
            "restaurant", 3
    );

    private static final Set<String> BUSINESS_CATEGORY = Set.of(
            "electronics",
            "grocery",
            "pharmacy",
            "restaurant"
    );

    public List<String> validateCoupons(String[] codes, String[] businessLines, boolean[] isActive) {
        int n = codes.length;
        List<Coupon> coupons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isValidCode(codes[i]) && isValidBusinessLine(businessLines[i]) && isActive[i]) {
                coupons.add(new Coupon(codes[i], businessLines[i]));
            }
        }

        return coupons.stream()
                .sorted(
                        Comparator.comparingInt((Coupon c) -> SORT_ORDER.get(c.businessLine))
                                .thenComparing((Coupon c) -> c.code)
                )
                .map(c -> c.code)
                .toList();
    }

    private boolean isValidCode(String code) {
        if (code == null || code.isEmpty()) {
            return false;
        }

        for (int i = 0; i < code.length(); i++) {
            char curr = code.charAt(i);

            if (isInvalidCodeChar(curr)) {
                return false;
            }
        }

        return true;
    }

    private boolean isInvalidCodeChar(char curr) {
        return !(curr == '_'
                || ('a' <= curr && curr <= 'z')
                || ('A' <= curr && curr <= 'Z')
                || Character.isDigit(curr));
    }

    private boolean isValidBusinessLine(String businessLine) {
        return businessLine != null && BUSINESS_CATEGORY.contains(businessLine);
    }

    private static class Coupon {

        private final String code;
        private final String businessLine;

        private Coupon(String code, String businessLine) {
            this.code = code;
            this.businessLine = businessLine;
        }
    }
}
