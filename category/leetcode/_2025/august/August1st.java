package category.leetcode._2025.august;

import java.util.ArrayList;
import java.util.List;

public class August1st {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        int count = 1;
        answer.add(new ArrayList<>(prev));

        while (count++ < numRows) {
            List<Integer> current = new ArrayList<>();
            current.add(1);

            for (int i = 0; i < prev.size() - 1; i++) {
                current.add(prev.get(i) + prev.get(i + 1));
            }

            current.add(1);
            prev = current;
            answer.add(new ArrayList<>(current));
        }

        return answer;
    }
}
