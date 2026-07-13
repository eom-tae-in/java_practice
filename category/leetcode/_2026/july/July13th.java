package category.leetcode._2026.july;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class July13th {

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            int num = i;
            int last = i + 1;

            while (num <= high && last <= 9) {
                num = num * 10 + last;

                if (low <= num && num <= high) {
                    answer.add(num);
                }

                last++;
            }
        }

        answer.sort(Comparator.naturalOrder());

        return answer;
    }
}
