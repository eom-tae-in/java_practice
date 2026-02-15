package category.leetcode._2026.february;

public class February15th {

    public String addBinary(String a, String b) {
        if (a.length() > b.length()) {
            return addBinary(b, a);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int aIdx = a.length() - 1;
        int bIdx = b.length() - 1;
        int carry = 0;

        while (aIdx >= 0) {
            int curr = (a.charAt(aIdx) - '0') + (b.charAt(bIdx) - '0') + carry;

            if (curr > 1) {
                carry = curr / 2;
                curr %= 2;
            } else {
                carry = 0;
            }

            stringBuilder.append(curr);
            aIdx--;
            bIdx--;
        }

        for (int i = bIdx; i >= 0; i--) {
            int curr = b.charAt(i) - '0' + carry;

            if (curr > 1) {
                carry = curr / 2;
                curr %= 2;
            } else {
                carry = 0;
            }

            stringBuilder.append(curr);
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }
}
