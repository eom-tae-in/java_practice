package category.leetcode._2025.march;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class March21st {

    public List<String> findAllRecipes(
            final String[] recipes,
            final List<List<String>> ingredients,
            final String[] supplies
    ) {
        List<String> answer = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dependencyCount = new HashMap<>();
        Set<String> suppliesSet = new HashSet<>(List.of(supplies));

        for (int i = 0; i < recipes.length; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    graph.putIfAbsent(ingredient, new ArrayList<>());
                    graph.get(ingredient).add(recipes[i]);
                    dependencyCount.merge(recipes[i], 1, Integer::sum);
                }
            }
        }

        Queue<String> queue = Arrays.stream(recipes)
                .filter(recipe -> dependencyCount.getOrDefault(recipe, 0) == 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        while (!queue.isEmpty()) {
            String current = queue.poll();
            answer.add(current);

            if (!graph.containsKey(current)) {
                continue;
            }

            for (String recipe : graph.get(current)) {
                dependencyCount.merge(recipe, -1, Integer::sum);

                if (dependencyCount.get(recipe) == 0) {
                    queue.offer(recipe);
                }
            }
        }

        return answer;
    }
}
