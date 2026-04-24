package category.leetcode._2026.april;

public class April24th {

    public int furthestDistanceFromOrigin(String moves) {
        int status = 0;
        int count = 0;

        for (int i = 0; i < moves.length(); i++) {
            char curr = moves.charAt(i);

            if (curr == 'L') {
                status += 1;
            } else if (curr == 'R') {
                status -= 1;
            } else {
                count++;
            }
        }

        if (status > 0) {
            return status + count;
        } else {
            return -status + count;
        }
    }
}
