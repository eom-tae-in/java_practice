package category.leetcode._2026.november;

public class November1st {

    public int minMoves(int[] nums) {
        int min = nums[0];

        for (int num : nums) {
            min = Math.min(min, num);
        }

        int moves = 0;

        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}
