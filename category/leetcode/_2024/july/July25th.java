package category.leetcode._2024.july;

public class July25th {

    public int[] sortArray(final int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(final int[] nums, final int left, final int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(final int[] nums, final int left, final int mid, final int right) {
        int[] arr = new int[right - left + 1];
        int index = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) {
                arr[index++] = nums[i++];
            } else {
                arr[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            arr[index++] = nums[i++];
        }
        while (j <= right) {
            arr[index++] = nums[j++];
        }

        System.arraycopy(arr, 0, nums, left, arr.length);
    }
}
