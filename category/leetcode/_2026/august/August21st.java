package category.leetcode._2026.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class August21st {

    public long findKthSmallest(int[] coins, int k) {
        List<Integer> filteredCoins = removeRedundantCoins(coins);
        long left = 0;
        long right = (long) filteredCoins.get(0) * k;

        while (left < right) {
            long mid = (left + right) / 2;

            if (countAmount(mid, 0, 0, 1L, filteredCoins) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countAmount(
            long limit,
            int start,
            int selectedCount,
            long currLcm,
            List<Integer> filteredCoins
    ) {
        long count = 0;

        for (int i = start; i < filteredCoins.size(); i++) {
            long nextLcm = calculateLcm(currLcm, filteredCoins.get(i), limit);

            if (nextLcm > limit) {
                continue;
            }

            long multiples = limit / nextLcm;

            if (selectedCount % 2 == 0) {
                count += multiples;
            } else {
                count -= multiples;
            }

            count += countAmount(limit, i + 1, selectedCount + 1, nextLcm, filteredCoins);
        }

        return count;
    }

    private long calculateLcm(long currLcm, long currCoin, long limit) {
        long gcd = getGcd(currLcm, currCoin);
        long dividedCoin = currCoin / gcd;

        if (dividedCoin > limit / currLcm) {
            return limit + 1;
        }

        return dividedCoin * currLcm;
    }

    private long getGcd(long a, long b) {
        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }


    private List<Integer> removeRedundantCoins(int[] coins) {
        Arrays.sort(coins);
        List<Integer> filteredCoins = new ArrayList<>();

        for (int coin : coins) {
            boolean redundant = false;

            for (int filteredCoin : filteredCoins) {
                if (coin % filteredCoin == 0) {
                    redundant = true;
                    break;
                }
            }

            if (!redundant) {
                filteredCoins.add(coin);
            }
        }

        return filteredCoins;
    }
}
