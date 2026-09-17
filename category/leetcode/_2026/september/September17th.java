package category.leetcode._2026.september;

public class September17th {

    private static final int INF = 1_000_000;

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int answer = INF;
        int minLength = INF;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int currentLength = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer, currentLength + best[left - 1]);
                }

                minLength = Math.min(minLength, currentLength);
            }

            best[right] = minLength;
        }

        return answer == INF ? -1 : answer;
    }
}
