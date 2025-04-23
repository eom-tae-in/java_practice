package category.leetcode._2025.april;

public class April23rd {

    public int countLargestGroup(int n) {
        int[] digitSumCounts = new int[40];
        int max = 0;
        int answer = 0;

        while (n > 0) {
            int sum = calculateNumDigitsSum(n);
            digitSumCounts[sum]++;

            if (max < digitSumCounts[sum]) {
                max = digitSumCounts[sum];
                answer = 1;
            } else if (max == digitSumCounts[sum]) {
                answer++;
            }

            n--;
        }

        return answer;
    }

    private int calculateNumDigitsSum(int n) {
        int total = 0;

        while (n > 0) {
            total += n % 10;
            n /= 10;
        }

        return total;
    }
}
