package category.leetcode._2025.april;

public class April24th {

    public int countCompleteSubarrays(final int[] nums) {
        int answer = 0;
        int wholeDistinctSum = 0;
        int currentDistinctSum = 0;
        int[] arr = new int[2001];

        for (int num : nums) {
            if (++arr[num] == 1) {
                wholeDistinctSum++;
            }
        }

        arr = new int[2001];

        for (int left = 0, right = 0; right < nums.length; right++) {
            if (++arr[nums[right]] == 1) {
                currentDistinctSum++;
            }

            while (currentDistinctSum == wholeDistinctSum) {
                if (--arr[nums[left]] == 0) {
                    currentDistinctSum--;
                }

                left++;
            }

            answer += left;
        }

        return answer;
    }
}
