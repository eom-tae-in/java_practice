package category.leetcode._2025.may;

public class May19th {

    public String triangleType(final int[] nums) {
        int primary = nums[0];
        int secondary = nums[1];
        int third = nums[2];

        if (primary + secondary <= third || primary + third <= secondary || secondary + third <= primary) {
            return "none";
        }

        if (primary == secondary && secondary == third) {
            return "equilateral";
        }

        if (primary == secondary || secondary == third || primary == third) {
            return "isosceles";
        }

        return "scalene";
    }
}
