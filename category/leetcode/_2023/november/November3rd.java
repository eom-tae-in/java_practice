package category.leetcode._2023.november;

import java.util.ArrayList;
import java.util.List;

public class November3rd {

    public List<String> buildArray(int[] target, int n) {
        List<String> answer = new ArrayList<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (target.length <= index) {
                break;
            }
            int num = target[index];
            answer.add("Push");
            if (num == i) {
                index++;
            } else {
                answer.add("Pop");
            }
        }

        return answer;
    }
}
