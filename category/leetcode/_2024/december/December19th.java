package category.leetcode._2024.december;

public class December19th {

    public int maxChunksToSorted(final int[] arr) {
        int answer = 0;
        int arrLength = arr.length;
        int currentMax = Integer.MIN_VALUE;

        for (int i = 0; i < arrLength; i++) {
            currentMax = Math.max(currentMax, arr[i]);

            if (currentMax == i) {
                answer++;
            }
        }

        return answer;
    }
}
