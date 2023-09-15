package category.leetcode.september;

import java.util.Arrays;

public class September13th {

    public int candy(int[] ratings) {
        int answer = 0;
        int size = ratings.length;
        int[] rightWay = new int[size];
        int[] leftWay = new int[size];
        Arrays.fill(rightWay, 1);
        Arrays.fill(leftWay, 1);

        for (int i = 0; i < size - 1; i++) {
            if (ratings[i + 1] > ratings[i]) {
                rightWay[i + 1] = rightWay[i] + 1;
            }
        }
        for (int i = size - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                leftWay[i - 1] = leftWay[i] + 1;
            }
        }
        for (int i = 0; i < size; i++) {
            answer += Math.max(rightWay[i], leftWay[i]);
        }
        return answer;
    }
}
