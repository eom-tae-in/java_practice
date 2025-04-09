package category.leetcode._2025.april;

public class April9th {

    public int minOperations(final int[] nums, final int k) {
        boolean[] isVisit = new boolean[101];
        int answer = 0;

        for (int num : nums) {
            isVisit[num] = true;
        }

        for (int i = 1; i < isVisit.length; i++) {
            if (isVisit[i] && i < k) {
                return -1;
            }

            if (isVisit[i] && i > k) {
                answer++;
            }
        }

        return answer;
    }
}
