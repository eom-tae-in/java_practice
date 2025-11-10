package category.leetcode._2025.november;

import java.util.ArrayDeque;
import java.util.Deque;

public class November10th {

    public int minOperations(int[] nums) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            while (stack.isEmpty() || stack.peek() < num) {
                answer++;
                stack.push(num);
            }
        }

        return answer;
    }
}
