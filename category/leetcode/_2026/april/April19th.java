package category.leetcode._2026.april;

public class April19th {

    public int maxDistance(int[] nums1, int[] nums2) {
        int answer = 0;
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                i++;
            } else {
                answer = Math.max(answer, j++ - i);
            }
        }

        return answer;
    }
}
