package category.leetcode._2026.may;

public class May19th {

    public int getCommon(int[] nums1, int[] nums2) {
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                return nums1[idx1];
            }
        }

        return -1;
    }
}
