package category.leetcode._2026.june;

public class June8th {

    public int[] pivotArray(int[] nums, int pivot) {
        int[] answer = new int[nums.length];
        int idx = 0;

        for (int num : nums) {
            if (num < pivot) {
                answer[idx++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                answer[idx++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                answer[idx++] = num;
            }
        }

        return answer;
    }
}
