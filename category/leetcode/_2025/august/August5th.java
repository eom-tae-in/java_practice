package category.leetcode._2025.august;

public class August5th {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int fruitsLength = fruits.length;
        int basketsLength = baskets.length;
        int answer = 0;

        for (int fruit : fruits) {
            boolean isPossible = false;

            for (int i = 0; i < basketsLength; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    isPossible = true;
                    break;
                }
            }

            if (!isPossible) {
                answer++;
            }
        }

        return answer;
    }
}
