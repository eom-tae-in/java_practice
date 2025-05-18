package category.leetcode._2025.may;

public class May18th {

    private static final int MOD = 1_000_000_007;
    private int m;
    private int n;
    private int[][] mem;

    public int colorTheGrid(final int m, final int n) {
        this.m = m;
        this.n = n;
        mem = new int[1000][1024];
        return dp(0, 0, 0, 0);
    }

    private int dp(
            final int r,
            final int c,
            final int prevColMask,
            final int currColMask
    ) {
        if (c == n) {
            return 1;
        }

        if (mem[c][prevColMask] != 0) {
            return mem[c][prevColMask];
        }

        if (r == m) {
            return dp(0, c + 1, currColMask, 0);
        }

        int answer = 0;

        for (int color = 1; color <= 3; color++) {
            if (getColor(prevColMask, r) == color) {
                continue;
            }

            if (r > 0 && getColor(currColMask, r - 1) == color) {
                continue;
            }

            answer += dp(r + 1, c, prevColMask, setColor(currColMask, r, color));
            answer %= MOD;
        }

        if (r == 0) {
            mem[c][prevColMask] = answer;
        }

        return answer;
    }

    private int getColor(final int mask, final int r) {
        return mask >> r * 2 & 3;
    }

    private int setColor(
            final int mask,
            final int r,
            final int color
    ) {
        return mask | color << r * 2;
    }
}

