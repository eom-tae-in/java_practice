package category.leetcode._2026.july;

public class July24th {

    private static final int MAX = 2048;

    public int uniqueXorTriplets(int[] nums) {
        boolean[] pair = new boolean[MAX];
        boolean[] triplet = new boolean[MAX];

        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }

        for (int xor = 0; xor < MAX; xor++) {
            if (!pair[xor]) {
                continue;
            }

            for (int num : nums) {
                triplet[xor ^ num] = true;
            }
        }

        int answer = 0;

        for (boolean possible : triplet) {
            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}
