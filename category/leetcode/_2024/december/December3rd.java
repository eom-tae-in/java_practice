package category.leetcode._2024.december;

public class December3rd {

    public String addSpaces(final String s, final int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder();
        int spaceIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            if (spaceIndex < spaces.length && i == spaces[spaceIndex]) {
                stringBuilder.append(" ");
                spaceIndex++;
            }
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }
}
