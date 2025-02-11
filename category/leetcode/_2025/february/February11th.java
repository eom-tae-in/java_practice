package category.leetcode._2025.february;

public class February11th {

    public String removeOccurrences(final String s, final String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int partLength = part.length();

        while (stringBuilder.indexOf(part) != -1) {
            int start = stringBuilder.indexOf(part);
            int end = start + partLength;
            stringBuilder.delete(start, end);
        }

        return stringBuilder.toString();
    }
}
