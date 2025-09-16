package category.leetcode._2025.september;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class September16th {

    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            while (!stack.isEmpty() && !isCoprime(stack.peek(), curr)) {
                curr = calculateLCM(stack.pop(), curr);
            }

            stack.push(curr);
        }

        List<Integer> answer = new ArrayList<>(stack);
        Collections.reverse(answer);

        return answer;
    }

    private boolean isCoprime(int primary, int secondary) {
        return gcd(primary, secondary) == 1;
    }

    private int gcd(int primary, int secondary) {
        while (secondary != 0) {
            int temp = secondary;
            secondary = primary % secondary;
            primary = temp;
        }

        return primary;
    }

    private int calculateLCM(int primary, int secondary) {
        return primary / gcd(primary, secondary) * secondary;
    }
}
