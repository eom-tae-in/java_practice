package category.leetcode._2025.february;

public class February10th {

    public String clearDigits(final String s) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            } else {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
