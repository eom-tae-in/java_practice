package category.leetcode._2025.september;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class September10th {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<int[]> invalid = new ArrayList<>();

        for (int[] friendship : friendships) {
            int u = friendship[0];
            int v = friendship[1];
            Set<Integer> setU = new HashSet<>();

            for (int lan : languages[u - 1]) {
                setU.add(lan);
            }

            boolean hasCommon = false;

            for (int lan : languages[v - 1]) {
                if (setU.contains(lan)) {
                    hasCommon = true;
                    break;
                }
            }

            if (!hasCommon) {
                invalid.add(friendship);
            }
        }

        Set<Integer> affected = new HashSet<>();

        for (int[] f : invalid) {
            affected.add(f[0]);
            affected.add(f[1]);
        }

        if (affected.isEmpty()) {
            return 0;
        }

        int answer = Integer.MAX_VALUE;

        for (int lan = 1; lan <= n; lan++) {
            int knows = 0;

            for (int user : affected) {
                for (int l : languages[user - 1]) {
                    if (l == lan) {
                        knows++;
                        break;
                    }
                }
            }

            answer = Math.min(answer, affected.size() - knows);
        }

        return answer;
    }
}
