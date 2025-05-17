package category.leetcode._2025.may;

public class May17th {

    public void sortColors(final int[] nums) {
        int redColorCount = 0;
        int whiteColorCount = 0;
        int blueColorCount = 0;

        for (int num : nums) {
            if (num == 0) {
                redColorCount++;
            } else if (num == 1) {
                whiteColorCount++;
            } else {
                blueColorCount++;
            }
        }

        int index = 0;

        for (int i = 0; i < redColorCount; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < whiteColorCount; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < blueColorCount; i++) {
            nums[index++] = 2;
        }
    }
}
