package category.leetcode._2026.august;

public class August18th {

    public int largestInteger(int[] nums, int k) {
        int[] count = new int[51];
        int answer = -1;

        if (nums.length == k) {
            for (int num : nums) {
                answer = Math.max(answer, num);
            }

            return answer;
        }

        for (int num : nums) {
            count[num]++;
        }

        if (k == 1) {
            for (int i = 50; i >= 0; i--) {
                if (count[i] == 1) {
                    return i;
                }
            }

            return -1;
        }

        if (count[nums[0]] == 1) {
            answer = nums[0];
        }

        if (count[nums[nums.length - 1]] == 1) {
            answer = Math.max(answer, nums[nums.length - 1]);
        }

        return answer;
    }
}
