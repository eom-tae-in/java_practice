package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class August13th {

    public List<List<Integer>> combinationSum2(final int[] candidates, final int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(
            final int index,
            final int[] candidates,
            final int target, List<Integer> path,
            final List<List<Integer>> answer
    ) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; ++i) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            path.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i], path, answer);
            path.remove(path.size() - 1);
        }
    }
}
