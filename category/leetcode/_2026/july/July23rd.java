package category.leetcode._2026.july;

public class July23rd {

    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return n;
        }

        int answer = 1;

        while (answer <= n) {
            answer <<= 1;
        }

        return answer;
    }
}
