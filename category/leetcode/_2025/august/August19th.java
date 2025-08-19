package category.leetcode._2025.august;

public class August19th {

    public long zeroFilledSubarray(int[] nums) {
        long answer = 0;
        int status = 0;

        for (int num : nums) {
            if (num == 0) {
                status++;
                answer += status;
            } else {
                status = 0;
            }
        }

        return answer;
    }
}
