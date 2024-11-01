package category.leetcode._2024.november;

public class November1st {

    public String makeFancyString(final String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);
        stringBuilder.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            if (prev == current) {
                count++;
            } else {
                prev = current;
                count = 1;
            }

            if (count < 3) {
                stringBuilder.append(current);
            }
        }

        return stringBuilder.toString();
    }
}
