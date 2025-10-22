package category.leetcode._2025.october;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class October22nd {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> line = new HashMap<>();
        Set<Integer> candidates = new HashSet<>();

        for (int num : nums) {
            count.merge(num, 1, Integer::sum);
            line.merge(num - k, 1, Integer::sum);
            line.merge(num + k + 1, -1, Integer::sum);
            candidates.add(num - k);
            candidates.add(num);
            candidates.add(num + k + 1);
        }

        int answer = 0;
        int accumulate = 0;

        for (int candidate : getOrderedCandidates(candidates)) {
            accumulate += line.getOrDefault(candidate, 0);
            int curr = count.getOrDefault(candidate, 0);
            int adj = accumulate - curr;
            answer = Math.max(answer, curr + Math.min(numOperations, adj));
        }

        return answer;
    }

    private List<Integer> getOrderedCandidates(Set<Integer> candidates) {
        List<Integer> orderedCandidates = new ArrayList<>(candidates);
        orderedCandidates.sort(Comparator.naturalOrder());

        return orderedCandidates;
    }
}
