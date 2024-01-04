package category.leetcode._2023.november;

public class November8th {

    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minCase = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));

        return minCase == 0 ? t != 1 : minCase <= t;
    }
}
