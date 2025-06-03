package category.leetcode._2025.june;

public class June3rd {

    public int maxCandies(
            int[] status,
            int[] candies,
            int[][] keys,
            int[][] containedBoxes,
            int[] initialBoxes
    ) {
        int n = status.length;
        boolean[] isVisited = new boolean[n];

        for (int box : initialBoxes) {
            dfs(box, status, isVisited, keys, containedBoxes);
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (status[i] == 1 && isVisited[i]) {
                answer += candies[i];
            }
        }

        return answer;
    }

    private void dfs(
            int box,
            int[] status,
            boolean[] isVisited,
            int[][] keys,
            int[][] containedBoxes
    ) {
        isVisited[box] = true;

        for (int key : keys[box]) {
            if (key == box && status[key] == 0) {
                continue;
            }

            status[key] = 1;
        }

        for (int containedBox : containedBoxes[box]) {
            if (!isVisited[containedBox]) {
                dfs(containedBox, status, isVisited, keys, containedBoxes);
            }
        }
    }
}
