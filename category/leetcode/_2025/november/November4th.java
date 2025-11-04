package category.leetcode._2025.november;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class November4th {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        Map<Integer, Integer> numFreq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqGroups = new TreeMap<>();
        int windowSum = 0;
        int[] answer = new int[n - k + 1];

        for (int i = 0; i < k - 1; i++) {
            int curr = nums[i];
            windowSum += curr;
            add(curr, numFreq, freqGroups);
        }

        for (int i = k - 1; i < n; i++) {
            int curr = nums[i];
            windowSum += curr;
            add(curr, numFreq, freqGroups);
            answer[i - k + 1] = getXSum(x, windowSum, numFreq, freqGroups);
            int removeNum = nums[i - k + 1];
            remove(removeNum, numFreq, freqGroups);
            windowSum -= removeNum;
        }

        return answer;
    }

    private void add(
            int num,
            Map<Integer, Integer> numFreq,
            TreeMap<Integer, TreeSet<Integer>> freqGroups
    ) {
        int oldFreq = numFreq.getOrDefault(num, 0);
        int newFreq = oldFreq + 1;
        numFreq.put(num, newFreq);

        if (oldFreq > 0) {
            TreeSet<Integer> group = freqGroups.get(oldFreq);
            group.remove(num);

            if (group.isEmpty()) {
                freqGroups.remove(oldFreq);
            }
        }

        freqGroups.computeIfAbsent(newFreq, key -> new TreeSet<>(Comparator.reverseOrder())).add(num);
    }

    private int getXSum(
            int x,
            int windowSum,
            Map<Integer, Integer> numFreq,
            TreeMap<Integer, TreeSet<Integer>> freqGroups
    ) {
        if (numFreq.size() <= x) {
            return windowSum;
        }

        int sum = 0;
        int count = 0;

        for (var entry : freqGroups.descendingMap().entrySet()) {
            int freq = entry.getKey();

            for (int num : entry.getValue()) {
                sum += freq * num;
                count++;

                if (count == x) {
                    return sum;
                }
            }
        }

        return sum;
    }

    private void remove(
            int num,
            Map<Integer, Integer> numFreq,
            TreeMap<Integer, TreeSet<Integer>> freqGroups
    ) {
        int oldFreq = numFreq.get(num);
        int newFreq = oldFreq - 1;

        TreeSet<Integer> group = freqGroups.get(oldFreq);
        group.remove(num);

        if (group.isEmpty()) {
            freqGroups.remove(oldFreq);
        }

        if (newFreq == 0) {
            numFreq.remove(num);
        } else {
            numFreq.put(num, newFreq);
            freqGroups.computeIfAbsent(newFreq, key -> new TreeSet<>(Comparator.reverseOrder())).add(num);
        }
    }
}
