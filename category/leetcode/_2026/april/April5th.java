package category.leetcode._2026.april;

public class April5th {

    public boolean judgeCircle(String moves) {
        int h = 0;
        int v = 0;

        for (int i = 0; i < moves.length(); i++) {
            char curr = moves.charAt(i);

            if (curr == 'L' || curr == 'R') {
                v += (curr == 'L' ? 1 : -1);
            } else {
                h += (curr == 'U' ? 1 : -1);
            }
        }

        return h == 0 && v == 0;
    }
}
