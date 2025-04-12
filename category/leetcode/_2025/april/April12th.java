package category.leetcode._2025.april;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class April12th {

    public long countGoodIntegers(final int n, final int k) {
        Set<String> set = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        int skip = n & 1;

        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(skip);
            long palindromicInteger = Long.parseLong(s);

            if (palindromicInteger % k == 0) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                set.add(new String(chars));
            }
        }

        long[] factorial = new long[n + 1];
        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        long answer = 0;

        for (String s : set) {
            int[] cnt = new int[10];

            for (char c : s.toCharArray()) {
                cnt[c - '0']++;
            }

            long tot = (n - cnt[0]) * factorial[n - 1];

            for (int x : cnt) {
                tot /= factorial[x];
            }

            answer += tot;
        }

        return answer;
    }
}
