package category.leetcode._2025.october;

public class October31st {

    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int sum = 0;
        int squareSum = 0;

        for (int num : nums) {
            sum += num;
            squareSum += num * num;
        }

        int diffSum = sum - n * (n - 1) / 2;  // x + y
        int diffSquareSum = squareSum - n * (n - 1) * (2 * n - 1) / 6; // x^2 + y^2
        int sneakyNumberMultiply = (diffSum * diffSum - diffSquareSum) / 2; // ((x + y)^2 - (x^2 + y^2)) / 2 == xy

        // 두 근은 x, y라고 하면 (t - x) (t - y) -> t^2 -(x+y)t + xy를 이용해서 푼다. 판별식 적용 D = b^2 - 4ac
        int d = (int) Math.sqrt(diffSum * diffSum - 4 * sneakyNumberMultiply);
        int x = (diffSum - d) / 2;
        int y = (diffSum + d) / 2;

        return new int[]{x, y};
    }
}
