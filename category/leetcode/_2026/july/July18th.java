package category.leetcode._2026.july;

public class July18th {

    public int findGCD(int[] nums) {
        int min = 1001;
        int max = 0;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return getGCD(min, max);
    }

    private int getGCD(int primary, int secondary) {
        while (secondary != 0) {
            int temp = primary % secondary;
            primary = secondary;
            secondary = temp;
        }

        return primary;
    }
}
