package category.leetcode._2024.november;

public class November4th {

    public String compressedString(final String word) {
        int n = word.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0, j = 0; i < n; i = j) {
            int count = 0;

            while (j < n && word.charAt(i) == word.charAt(j) && count < 9) {
                j++;
                count++;
            }

            stringBuilder.append(count).append(word.charAt(i));
        }

        return stringBuilder.toString();
    }
}
