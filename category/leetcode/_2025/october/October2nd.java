package category.leetcode._2025.october;

public class October2nd {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int answer = numBottles;

        while (numBottles >= numExchange) {
            numBottles = (numBottles - numExchange + 1);
            numExchange++;
            answer++;
        }

        return answer;
    }
}
