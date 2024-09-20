package category.leetcode._2024.july;

public class July1st {

    public boolean threeConsecutiveOdds(final int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }

        return false;
    }
}
