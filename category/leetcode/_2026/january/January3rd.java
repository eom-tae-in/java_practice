package category.leetcode._2026.january;

public class January3rd {

    public int numOfWays(int n) {
        int mod = 1_000_000_007;
        long color2 = 6;
        long color3 = 6;

        for (int i = 1; i < n; ++i) {
            long nextColor2 = color2 * 3 + color3 * 2;
            long nextColor3 = color2 * 2 + color3 * 2;
            color2 = nextColor2 % mod;
            color3 = nextColor3 % mod;
        }

        return (int) ((color2 + color3) % mod);
    }
}
