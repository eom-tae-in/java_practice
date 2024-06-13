package category.leetcode._2024.May;

import java.util.ArrayList;
import java.util.List;

public class May22nd {

    public List<List<String>> partition(final String s) {
        List<List<String>> answer = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        dfs(s, 0, currentPartition, answer);

        return answer;
    }

    private void dfs(final String s, final int startIndex, final List<String> currentPartition,
                     final List<List<String>> answer) {
        if (startIndex == s.length()) {
            answer.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                currentPartition.add(s.substring(startIndex, i + 1));
                dfs(s, i + 1, currentPartition, answer);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(final String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
