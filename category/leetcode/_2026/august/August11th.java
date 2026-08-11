package category.leetcode._2026.august;

public class August11th {

    public int missingInteger(int[] nums) {
        int[] count = new int[51];
        int sequentialSum = 0;
        boolean isSequential = true;
        int prev = nums[0] - 1;

        for (int curr : nums) {
            if (isSequential) {
                if (prev + 1 == curr) {
                    sequentialSum += curr;
                } else {
                    isSequential = false;
                }
            }

            count[curr]++;
            prev = curr;
        }

        int answer = sequentialSum;

        while (answer <= 50) {
            if (count[answer] == 0) {
                break;
            }

            answer++;
        }

        return answer;
    }
}
