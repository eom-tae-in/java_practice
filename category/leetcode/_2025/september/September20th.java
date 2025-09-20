package category.leetcode._2025.september;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class September20th {

    private static class Router {
        private final Queue<Packet> queue;
        private final Set<Packet> unique;
        private final Map<Integer, List<Integer>> destTimestamps;
        private final Map<Integer, Integer> forwardedCount;
        private final int memoryLimit;

        public Router(int memoryLimit) {
            queue = new LinkedList<>();
            unique = new HashSet<>();
            destTimestamps = new HashMap<>();
            forwardedCount = new HashMap<>();
            this.memoryLimit = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            Packet packet = new Packet(source, destination, timestamp);

            if (unique.contains(packet)) {
                return false;
            }

            if (queue.size() == memoryLimit) {
                forwardPacket();
            }

            queue.offer(packet);
            unique.add(packet);
            destTimestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
            forwardedCount.putIfAbsent(destination, 0);

            return true;
        }

        public int[] forwardPacket() {
            Packet packet = queue.poll();

            if (packet == null) {
                return new int[0];
            }

            unique.remove(packet);
            int dest = packet.destination;
            forwardedCount.put(dest, forwardedCount.getOrDefault(dest, 0) + 1);

            return new int[]{packet.source, packet.destination, packet.timestamp};
        }

        public int getCount(int destination, int startTime, int endTime) {
            List<Integer> tsList = destTimestamps.get(destination);

            if (tsList == null) {
                return 0;
            }

            int fwd = forwardedCount.getOrDefault(destination, 0);
            int lo = lowerBound(tsList, startTime, fwd);
            int hi = upperBound(tsList, endTime, fwd);
            return hi - lo;
        }

        private int lowerBound(List<Integer> list, int value, int startIdx) {
            int left = startIdx;
            int right = list.size();

            while (left < right) {
                int m = left + (right - left) / 2;

                if (list.get(m) < value) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }

            return left;
        }

        private int upperBound(List<Integer> list, int value, int startIdx) {
            int left = startIdx;
            int right = list.size();

            while (left < right) {
                int m = left + (right - left) / 2;

                if (list.get(m) <= value) {
                    left = m + 1;
                } else {
                    right = m;
                }
            }

            return left;
        }

        private record Packet(int source, int destination, int timestamp) {
        }
    }
}
