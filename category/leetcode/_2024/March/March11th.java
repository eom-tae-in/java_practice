package category.leetcode._2024.March;

public class March11th {

    public String customSortString(final String order, final String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] counts = new int[128];

        for (char ch : s.toCharArray()) {
            counts[ch]++;
        }

        for (char ch : order.toCharArray()) {
            while (counts[ch]-- > 0) {
                stringBuilder.append(ch);
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            while (counts[ch]-- > 0) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
