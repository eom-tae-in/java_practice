package category.leetcode._2025.october;

public class October25th {

    public int totalMoney(int n) {
        int quotient = n / 7;
        int rest = n % 7;
        int answer = 0;

        if (rest != 0) {
            int weight = 1;

            while (rest > 0) {
                answer += quotient + weight;
                weight++;
                rest--;
            }
        }

        answer += 7 * quotient * (quotient - 1) / 2 + 28 * quotient;

        return answer;
    }
}
