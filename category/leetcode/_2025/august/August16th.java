package category.leetcode._2025.august;

public class August16th {

    public int maximum69Number(int num) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        int length = stringBuilder.length();

        for (int i = 0; i < length; i++) {
            if (stringBuilder.charAt(i) == '6') {
                stringBuilder.setCharAt(i, '9');
                break;
            }
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
