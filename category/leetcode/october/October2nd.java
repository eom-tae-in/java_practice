package category.leetcode.october;

public class October2nd {

    public boolean winnerOfGame(String colors) {
        int countAAA = 0;
        int countBBB = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            char current = colors.charAt(i);
            if (current == colors.charAt(i - 1) && current == colors.charAt(i + 1)) {
                if (current == 'A') {
                    countAAA++;
                } else {
                    countBBB++;
                }
            }
        }
        return countAAA > countBBB;
    }
}
