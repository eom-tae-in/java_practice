package category.leetcode._2025.april;

public class April11th {

    public int countSymmetricIntegers(final int low, final int high) {
        int answer = 0;

        for (int i = low; i <= high; i++) {
            if (isSymmetric(i)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isSymmetric(final int num) {
        String strNum = String.valueOf(num);

        if (strNum.length() % 2 == 1) {
            return false;
        }

        int numLength = strNum.length();
        int halfLength = numLength / 2;
        int prev = 0;
        int next = 0;

        for (int i = 0; i < halfLength; i++) {
            prev += strNum.charAt(i);
        }

        for (int i = halfLength; i < numLength; i++) {
            next += strNum.charAt(i);
        }

        return prev == next;
    }
}
