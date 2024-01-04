package category.leetcode._2023.august;

public class August14th {
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];
        for (int num : nums) {
            count[num + 10000]++;
        }
        for (int i = 20000; i > -1; i--) {
            k -= count[i];
            if (k <= 0){
                return i - 10000;
            }
        }
        return 0;
    }
}
