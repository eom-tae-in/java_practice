package category.leetcode._2026.november;

public class November5th {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int answer = 0;

        for (int a : arr1) {
            boolean valid = true;

            for (int b : arr2) {
                if (Math.abs(a - b) <= d) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer++;
            }
        }

        return answer;
    }
}
