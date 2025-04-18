package category.leetcode._2025.april;

public class April18th {

    public String countAndSay(final int n) {
        String word = "1";
        int count = 2;

        while (count <= n) {
            StringBuilder stringBuilder = new StringBuilder();
            char prev = word.charAt(0);
            int length = word.length();
            int charCount = 1;

            for (int i = 1; i < length; i++) {
                char current = word.charAt(i);

                if (prev == current) {
                    charCount++;
                } else {
                    stringBuilder.append(charCount).append(prev);
                    prev = current;
                    charCount = 1;
                }
            }

            stringBuilder.append(charCount).append(prev);
            count++;
            word = stringBuilder.toString();
        }

        return word;
    }
}
