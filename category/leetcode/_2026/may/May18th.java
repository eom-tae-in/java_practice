package category.leetcode._2026.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class May18th {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] seen = new boolean[n];
        queue.offer(0);
        seen[0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    return step;
                }

                if (map.containsKey(arr[curr])) {
                    for (int next : map.get(arr[curr])) {
                        if (!seen[next]) {
                            seen[next] = true;
                            queue.offer(next);
                        }
                    }

                    map.remove(arr[curr]);
                }

                if (curr + 1 < n && !seen[curr + 1]) {
                    seen[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !seen[curr - 1]) {
                    seen[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }

            step++;
        }

        return -1;
    }
}
