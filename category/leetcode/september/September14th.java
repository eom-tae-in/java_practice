package category.leetcode.september;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class September14th {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> answer = new LinkedList<>();
        Map<String, Queue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String key = ticket.get(0);
            map.putIfAbsent(key, new PriorityQueue<>());
            map.get(key).offer(ticket.get(1));
        }
        dfs(map, "JFK", answer);

        return answer;
    }

    private void dfs(Map<String, Queue<String>> map, String key, LinkedList<String> answer) {
        Queue<String> values = map.get(key);
        while (values != null && values.isEmpty()) {
            dfs(map, values.poll(), answer);
        }
        answer.addFirst(key);
    }
}
