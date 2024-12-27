package category.leetcode._2024.december;

public class December27th {

    public int maxScoreSightseeingPair(final int[] values) {
        int answer = 0;
        int prevMax = 0;

        for (int value : values) {
            answer = Math.max(answer, prevMax + value);
            prevMax = Math.max(prevMax, value) - 1;
        }

        return answer;
    }
}
