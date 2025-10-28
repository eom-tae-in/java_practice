package category.leetcode._2025.october;

public class October28th {

    public int countValidSelections(int[] nums) {
        int answer = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int accumulate = 0;

        for (int num : nums) {
            accumulate += num;

            if (num == 0) {
                if (accumulate * 2 == sum) {
                    answer += 2;
                } else if (Math.abs(accumulate * 2 - sum) == 1) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
