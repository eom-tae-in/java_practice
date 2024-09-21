package category.leetcode._2024.september;

import java.util.ArrayList;
import java.util.List;

public class September21st {

    public List<Integer> lexicalOrder(final int n) {
        List<Integer> answer = new ArrayList<>();
        int current = 1;
        while (answer.size() < n) {
            answer.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current % 10 == 9 || current == n) {
                    current /= 10;
                }
                ++current;
            }
        }

        return answer;
    }
}
