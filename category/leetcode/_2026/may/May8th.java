package category.leetcode._2026.may;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class May8th {

    public int minJumps(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return 0;
        }

        int maxVal = 0;

        for (int x : nums) {
            maxVal = Math.max(maxVal, x);
        }

        int[] spf = buildSPF(maxVal);
        Map<Integer, List<Integer>> primeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> primes = getPrimeFactors(nums[i], spf);

            for (int prime : primes) {
                primeMap.computeIfAbsent(prime, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        Set<Integer> usedPrime = new HashSet<>();
        q.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int i = q.poll();

                if (i == n - 1) {
                    return steps;
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    q.offer(i - 1);
                }

                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                int val = nums[i];

                if (val > 1 && spf[val] == val && !usedPrime.contains(val)) {
                    usedPrime.add(val);

                    if (primeMap.containsKey(val)) {
                        for (int idx : primeMap.get(val)) {
                            if (!visited[idx]) {
                                visited[idx] = true;
                                q.offer(idx);
                            }
                        }
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private int[] buildSPF(int max) {
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {
                for (int j = i; j <= max; j += i) {
                    if (spf[j] == 0) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    private Set<Integer> getPrimeFactors(int x, int[] spf) {
        Set<Integer> set = new HashSet<>();

        while (x > 1) {
            set.add(spf[x]);
            x /= spf[x];
        }

        return set;
    }
}
