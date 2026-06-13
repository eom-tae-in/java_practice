package category.leetcode._2026.june;

public class June13th {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : words) {
            int sum = 0;

            for (char ch : word.toCharArray()) {
                sum += weights[ch - 'a'];
            }

            stringBuilder.append((char) ('z' - (sum % 26)));
        }

        return stringBuilder.toString();
    }
}
