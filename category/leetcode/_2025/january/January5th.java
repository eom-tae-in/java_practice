package category.leetcode._2025.january;

public class January5th {

    public String shiftingLetters(final String s, final int[][] shifts) {
        StringBuilder stringBuilder = new StringBuilder();
        int currShift = 0;
        int[] timeline = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            int diff = direction == 1 ? 1 : -1;
            timeline[start] += diff;
            timeline[end + 1] -= diff;
        }

        for (int i = 0; i < s.length(); i++) {
            currShift = (currShift + timeline[i]) % 26;
            int num = (s.charAt(i) - 'a' + currShift + 26) % 26;
            stringBuilder.append((char) ('a' + num));
        }

        return stringBuilder.toString();
    }
}
