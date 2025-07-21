package category.leetcode._2025.july;

public class July21st {

    public String makeFancyString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int consecutiveCount = 1;
        char prev = '@';

        for (char ch : s.toCharArray()) {
            if (prev == ch) {
                consecutiveCount++;
            } else {
                prev = ch;
                consecutiveCount = 1;
            }

            if (consecutiveCount < 3) {
                stringBuilder.append(ch);
            }
        }

        return stringBuilder.toString();
    }
}
