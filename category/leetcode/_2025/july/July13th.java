package category.leetcode._2025.july;

import java.util.Arrays;

public class July13th {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int answer = 0;
        int trainerIndex = 0;

        for (int player : players) {
            while (trainerIndex < trainers.length && trainers[trainerIndex] < player) {
                trainerIndex++;
            }

            if (trainerIndex == trainers.length) {
                break;
            }

            answer++;
            trainerIndex++;
        }

        return answer;
    }
}
