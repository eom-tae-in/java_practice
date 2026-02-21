package category.leetcode._2026.february;

public class February21st {

    public int countPrimeSetBits(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            int bitCount = Integer.bitCount(i);

            if (isPrime(bitCount)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
