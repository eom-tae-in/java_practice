package category.leetcode._2026.august;

public class August22nd {

    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int curr = n;

        while (curr > 0) {
            int remainder = curr % 10;
            digitSum += remainder;
            digitProduct *= remainder;
            curr /= 10;
        }

        return n % (digitSum + digitProduct) == 0;
    }
}
