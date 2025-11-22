package category.leetcode._2025.november;

public class November22nd {

    public int minimumOperations(int[] nums) {
        int answer = 0;

        for (int num : nums) {
            if (num % 3 != 0) {
                answer++;
            }
        }

        return answer;
    }
}
