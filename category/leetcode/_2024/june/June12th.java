package category.leetcode._2024.june;

public class June12th {

    public void sortColors(final int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    private void quickSort(final int[] nums, final int low, final int high) {
        if (low < high) {
            int pivot = parition(nums, low, high);
            quickSort(nums, low, pivot - 1);
            quickSort(nums, pivot, high);
        }
    }

    private int parition(final int[] nums, int low, int high) {
        int pivot = nums[(low + high) / 2];
        while (low <= high) {
            while (nums[low] < pivot) {
                low++;
            }

            while (nums[high] > pivot) {
                high--;
            }
            if (low <= high) {
                swap(nums, low, high);
                low++;
                high--;
            }
        }

        return low;
    }

    private void swap(final int[] nums, final int low, final int high) {
        int temp = nums[low];
        nums[low] = nums[high];
        nums[high] = temp;
    }
}
