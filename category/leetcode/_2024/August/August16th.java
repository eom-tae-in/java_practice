package category.leetcode._2024.August;

import java.util.List;

public class August16th {

    public int maxDistance(final List<List<Integer>> arrays) {
        int answer = 0;
        int min = 10000;
        int max = -10000;
        for (List<Integer> A : arrays) {
            answer = Math.max(answer, Math.max(A.get(A.size() - 1) - min, max - A.get(0)));
            min = Math.min(min, A.get(0));
            max = Math.max(max, A.get(A.size() - 1));
        }

        return answer;
    }
}
