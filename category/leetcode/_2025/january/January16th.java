package category.leetcode._2025.january;

public class January16th {

    public int xorAllNums(final int[] nums1, final int[] nums2) {
        int answer = 0;
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;

        if (nums1Length % 2 == 0 && nums2Length % 2 == 0) {
            return 0;
        }

        if (nums1Length % 2 == 0) {
            for (int num : nums1) {
                answer ^= num;
            }

            return answer;
        }

        if (nums2Length % 2 == 0) {
            for (int num : nums2) {
                answer ^= num;
            }

            return answer;
        }

        for (int num : nums1) {
            answer ^= num;
        }

        for (int num : nums2) {
            answer ^= num;
        }

        return answer;
    }
}
