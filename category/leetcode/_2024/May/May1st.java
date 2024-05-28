package category.leetcode._2024.May;

public class May1st {

    public String reversePrefix(final String word, final char ch) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (isSame(ch, word.charAt(i))) {
                String prefix = word.substring(0, i + 1);
                stringBuilder.append(prefix).reverse();
                String suffix = word.substring(i + 1);
                stringBuilder.append(suffix);
                break;
            }
        }

        return stringBuilder.length() == 0 ? word : stringBuilder.toString();
    }

    private boolean isSame(final char ch, final char wordChar) {
        return ch == wordChar;
    }
}
