package category.leetcode._2024.July;

public class July7th {

    public int numWaterBottles(final int numBottles, final int numExchange) {
        int current = numBottles;
        int answer = numBottles;
        while (current >= numExchange) {
            int quotient = current / numExchange;
            answer += quotient;
            current = quotient + current % numExchange;
        }

        return answer;
    }
}
