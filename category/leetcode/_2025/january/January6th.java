package category.leetcode._2025.january;

public class January6th {

    public int[] minOperations(final String boxes) {
        int boxesLength = boxes.length();
        int[] answer = new int[boxesLength];
        int count = 0;
        int moves = 0;

        for (int i = 0; i < boxesLength; i++) {
            answer[i] += moves;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            moves += count;
        }

        count = 0;
        moves = 0;

        for (int i = boxesLength - 1; i >= 0; i--) {
            answer[i] += moves;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            moves += count;
        }

        return answer;
    }
}
