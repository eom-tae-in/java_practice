package category.leetcode._2023.november;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class November12th {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        Queue<Integer> queue = new ArrayDeque<>(List.of(source));

        for (int i = 0; i < routes.length; ++i)
            for (final int route : routes[i]) {
                graph.putIfAbsent(route, new ArrayList<>());
                graph.get(route).add(i);
            }

        while (!queue.isEmpty()) {
            ++ans;
            for (int size = queue.size(); size > 0; --size) {
                for (final int bus : graph.get(queue.poll()))
                    if (set.add(bus))
                        for (final int nextRoute : routes[bus]) {
                            if (nextRoute == target)
                                return ans;
                            queue.offer(nextRoute);
                        }
            }
        }

        return -1;
    }
}
