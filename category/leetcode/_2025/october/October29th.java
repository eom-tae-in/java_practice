package category.leetcode._2025.october;

public class October29th {

    public int smallestNumber(int n) {
        int target = 1;

        while (n >= target) {
            target *= 2;
        }

        return target - 1;
    }
}
