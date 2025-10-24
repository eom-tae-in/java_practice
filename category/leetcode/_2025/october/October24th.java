package category.leetcode._2025.october;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class October24th {

    private static final int THRESHOLD = 1224444;

    public int nextBeautifulNumber(int n) {
        List<Integer> beautifulNumbers = generateBeautifulNumbers();
        beautifulNumbers.sort(Comparator.naturalOrder());

        for (int beautifulNumber : beautifulNumbers) {
            if (beautifulNumber > n) {
                return beautifulNumber;
            }
        }

        return -1;
    }

    private List<Integer> generateBeautifulNumbers() {
        int[] count = new int[10];
        List<Integer> beautifulNumbers = new ArrayList<>();
        dfs(0, count, beautifulNumbers);

        return beautifulNumbers;
    }

    private void dfs(int num, int[] count, List<Integer> beautifulNumbers) {
        if (num > 0 && isBeautifulNumber(count)) {
            beautifulNumbers.add(num);
        }

        if (num > THRESHOLD) {
            return;
        }

        for (int i = 1; i <= 7; i++) {
            if (count[i] < i) {
                count[i]++;
                dfs(num * 10 + i, count, beautifulNumbers);
                count[i]--;
            }
        }
    }

    private boolean isBeautifulNumber(int[] count) {
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && count[i] != i) {
                return false;
            }
        }

        return true;
    }
}
