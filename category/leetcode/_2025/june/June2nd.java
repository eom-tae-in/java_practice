package category.leetcode._2025.june;

public class June2nd {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int answer = n;

        for (int i = 0; i < n - 1; ) {
            int[] result = calculateCandyForSlope(ratings, i);
            i = result[0];
            answer += result[1];
        }

        return answer;
    }

    private int[] calculateCandyForSlope(int[] ratings, int index) {
        int peak = 0;
        int dip = 0;
        int sum = 0;
        int n = ratings.length;
        boolean isDipStarted = false;
        int i = index;

        for (; i < n - 1; i++) {
            boolean isIncrease = ratings[i] < ratings[i + 1];
            boolean isDecrease = ratings[i] > ratings[i + 1];

            if (!isIncrease && !isDecrease) {
                i++;
                break;
            }

            if (isIncrease) {
                if (isDipStarted) {
                    break;
                }

                peak++;
                sum += peak;
            } else {
                isDipStarted = true;
                dip++;
                sum += dip;
            }
        }

        sum -= Math.min(dip, peak);
        return new int[]{i, sum};
    }
}
