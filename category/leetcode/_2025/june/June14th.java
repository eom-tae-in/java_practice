package category.leetcode._2025.june;

public class June14th {

    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        char to9 = findFirstNotNine(numStr);
        char to0 = numStr.charAt(0);
        int max = 0;
        int min = 0;

        if (to9 == '@') {
            max = num;
        } else {
            max = getMax(numStr, to9);
        }

        min = getMin(numStr, to0);
        return max - min;
    }

    private char findFirstNotNine(String numStr) {
        char ch = '@';

        for (char numCh : numStr.toCharArray()) {
            if (numCh != '9') {
                return numCh;
            }
        }

        return ch;
    }

    private int getMax(String numStr, char to9) {
        StringBuilder stringBuilder = new StringBuilder(numStr);
        int n = numStr.length();

        for (int i = 0; i < n; i++) {
            if (numStr.charAt(i) == to9) {
                stringBuilder.setCharAt(i, '9');
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    private int getMin(String numStr, char to0) {
        StringBuilder stringBuilder = new StringBuilder(numStr);
        int n = numStr.length();

        for (int i = 0; i < n; i++) {
            if (numStr.charAt(i) == to0) {
                stringBuilder.setCharAt(i, '0');
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
