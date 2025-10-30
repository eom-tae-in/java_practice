package category.leetcode._2025.october;

public class October30th {

    public int minNumberOperations(int[] target) {
        int answer = target[0];

        for (int i = 0; i < target.length - 1; i++) {
            answer += Math.max(target[i + 1] - target[i], 0);
        }

        return answer;
    }
}
