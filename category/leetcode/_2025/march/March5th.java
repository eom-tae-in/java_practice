package category.leetcode._2025.march;

public class March5th {

    public long coloredCells(int n) {
        long answer = 1;
        int change = 4;

        while (n-- > 1) {
            answer += change;
            change += 4;
        }

        return answer;
    }
}
