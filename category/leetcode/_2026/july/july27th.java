package category.leetcode._2026.july;

public class july27th {

    public int maxProduct(int[] nums) {
        int primary = 0;
        int secondary = 0;

        for (int num : nums) {
            if (num > primary) {
                secondary = primary;
                primary = num;
            } else if (num > secondary) {
                secondary = num;
            }
        }

        return (primary - 1) * (secondary - 1);
    }
}
