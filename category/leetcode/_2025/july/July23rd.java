package category.leetcode._2025.july;

public class July23rd {

    public int maximumGain(String s, int x, int y) {
        int answer = 0;
        char primary = 'a';
        char secondary = 'b';

        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
            primary = 'b';
            secondary = 'a';
        }

        int primaryCount = 0;
        int secondaryCount = 0;

        for (char ch : s.toCharArray()) {
            if (ch == primary) {
                primaryCount++;
            } else if (ch == secondary) {
                if (primaryCount > 0) {
                    answer += x;
                    primaryCount--;
                } else {
                    secondaryCount++;
                }
            } else {
                answer += Math.min(primaryCount, secondaryCount) * y;
                primaryCount = 0;
                secondaryCount = 0;
            }
        }

        answer += Math.min(primaryCount, secondaryCount) * y;
        return answer;
    }
}
