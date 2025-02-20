package category.leetcode._2025.february;

import java.util.Arrays;

public class February20th {

    public String findDifferentBinaryString(final String[] nums) {
        String[] answer = new String[1];
        dfs(new StringBuilder(), nums, answer);

        return answer[0];
    }

    private void dfs(
            final StringBuilder stringBuilder,
            final String[] nums,
            final String[] answer
    ) {
        if (stringBuilder.length() == nums.length) {
            String current = stringBuilder.toString();
            boolean result = Arrays.stream(nums)
                    .noneMatch(num -> num.equals(current));

            if (result) {
                answer[0] = current;
            }

            return;
        }

        for (int i = 0; i <= 1; i++) {
            if (answer[0] != null) {
                continue;
            }

            stringBuilder.append(i);
            dfs(stringBuilder, nums, answer);
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
    }
}
