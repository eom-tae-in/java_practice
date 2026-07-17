package category.leetcode._2026.july;

public class July17th {

    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] count = new int[max + 1];

        for (int num : nums) {
            count[num]++;
        }

        long[] gcdCount = new long[max + 1];

        for (int num = max; num >= 1; num--) {
            long currCount = 0;

            for (int multiply = num; multiply <= max; multiply += num) {
                currCount += count[multiply];
            }

            long pair = currCount * (currCount - 1) / 2;

            for (int multiply = num + num; multiply <= max; multiply += num) {
                pair -= gcdCount[multiply];
            }

            gcdCount[num] = pair;
        }

        long[] prefix = new long[max + 1];

        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + gcdCount[i];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int left = 1;
            int right = max;
            long target = queries[i] + 1;

            while (left < right) {
                int mid = (left + right) / 2;

                if (prefix[mid] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            answer[i] = left;
        }

        return answer;
    }
}
