package category.leetcode._2025.april;

public class April8th {

    public int minimumOperations(final int[] nums) {
        int answer = 0;
        int duplicateCount = 0;
        int[] numsCount = new int[101];

        for (int num : nums) {
            if (++numsCount[num] == 2) {
                duplicateCount++;
            }
        }

        int lastIndex = nums.length - 1;
        int index = 0;

        while (duplicateCount > 0) {
            if (lastIndex - index < 2) {
                answer++;
                break;
            }

            for (int i = index; i < index + 3; i++) {
                if (--numsCount[nums[i]] == 1) {
                    duplicateCount--;
                }
            }

            answer++;
            index += 3;
        }

        return answer;
    }
}
