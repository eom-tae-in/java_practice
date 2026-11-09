package category.leetcode._2026.november;

import java.util.*;

public class November9th {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available = new TreeSet<>();

        for (int server = 0; server < k; server++) {
            available.add(server);
        }

        PriorityQueue<long[]> busy = new PriorityQueue<>(Comparator.comparingLong(job -> job[0]));
        int[] handled = new int[k];
        int maxHandled = 0;

        for (int i = 0; i < arrival.length; i++) {
            int now = arrival[i];

            while (!busy.isEmpty() && busy.peek()[0] <= now) {
                int server = (int) busy.poll()[1];
                available.add(server);
            }

            if (available.isEmpty()) {
                continue;
            }

            Integer server = available.ceiling(i % k);

            if (server == null) {
                server = available.first();
            }

            available.remove(server);
            busy.offer(new long[]{(long) now + load[i], server});
            handled[server]++;
            maxHandled = Math.max(maxHandled, handled[server]);
        }

        List<Integer> result = new ArrayList<>();

        for (int server = 0; server < k; server++) {
            if (handled[server] == maxHandled) {
                result.add(server);
            }
        }

        return result;
    }
}
