package category.leetcode._2023.september;

public class September29th {

    public  boolean isMonotonic(int[] nums) {
        int type = 0;
        int index = 0;

        while(type == 0) {
            if (index == nums.length - 1) {
                break;
            }
            if(nums[index] == nums[index + 1]) {
                index++;
                continue;
            }
            if(nums[index] < nums[index + 1]) {
                type = 1;
            }
            if(nums[index] > nums[index + 1]) {
                type = -1;
            }
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (type == 1) {
                if (nums[i] > nums[i + 1]) {
                    return false;
                }
            }
            else {
                if (nums[i] < nums[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
