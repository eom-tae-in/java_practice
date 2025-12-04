package category.leetcode._2025.december;

public class December4th {

    public int countCollisions(String directions) {
        int left = 0;
        int right = directions.length() - 1;

        while (left < right && directions.charAt(left) == 'L') {
            left++;
        }

        while (left < right && directions.charAt(right) == 'R') {
            right--;
        }

        if (left >= right) {
            return 0;
        }

        int sCount = 0;

        for (int i = left; i <= right; i++) {
            if (directions.charAt(i) == 'S') {
                sCount++;
            }
        }

        return right - left + 1 - sCount;
    }
}
