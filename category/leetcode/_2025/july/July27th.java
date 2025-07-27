package category.leetcode._2025.july;

public class July27th {

    public int countHillValley(int[] nums) {
        int answer = 0;
        int prev = nums[0];
        int numsLength = nums.length;

        for (int i = 1; i < numsLength - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];

            if ((prev < current && next < current) || (current < prev && current < next)) {
                answer++;
            }

            if (current != next) {
                prev = current;
            }
        }

        return answer;
    }
}
