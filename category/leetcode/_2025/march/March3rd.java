package category.leetcode._2025.march;

public class March3rd {

    public int[] pivotArray(final int[] nums, final int pivot) {
        int[] answer = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                answer[index++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                answer[index++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                answer[index++] = num;
            }
        }

        return answer;
    }
}
