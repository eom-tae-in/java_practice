package category.leetcode._2026.february;

public class February16th {

    public int reverseBits(int n) {
        int answer = 0;

        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 1) {
                answer |= 1 << 31 - i;
            }
        }

        return answer;
    }
}
