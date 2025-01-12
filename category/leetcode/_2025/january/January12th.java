package category.leetcode._2025.january;

public class January12th {

    public boolean canBeValid(final String s, final String locked) {
        if (s.length() % 2 == 1) {
            return false;
        }

        return check(s, locked, true) &&
                check(
                        new StringBuilder(s).reverse().toString(),
                        new StringBuilder(locked).reverse().toString(),
                        false
                );
    }

    private boolean check(final String s, final String locked, final boolean isForward) {
        int changeable = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            char lock = locked.charAt(i);

            if (lock == '0') {
                ++changeable;
            } else if (c == '(') {
                ++l;
            } else {
                ++r;
            }

            if (isForward && changeable + l - r < 0) {
                return false;
            }

            if (!isForward && changeable + r - l < 0) {
                return false;
            }
        }

        return true;
    }
}
