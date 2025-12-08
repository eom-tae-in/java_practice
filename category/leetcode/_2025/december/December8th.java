package category.leetcode._2025.december;

public class December8th {

    public int countTriples(int n) {
        int answer = 0;
        boolean[] square = new boolean[n * n + 1];

        for (int i = 1; i <= n; i++) {
            square[i * i] = true;
        }

        for (int a = 1; a < n; a++) {
            int aa = a * a;

            for (int b = 1; b < n; b++) {
                int sum = aa + b * b;

                if (sum <= n * n && square[sum]) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
