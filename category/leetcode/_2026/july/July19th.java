package category.leetcode._2026.july;

public class July19th {

    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        boolean[] visited = new boolean[26];
        int n = s.length();

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);

            if (visited[curr - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.charAt(stack.length() - 1) > curr
                    && lastIndex[stack.charAt(stack.length() - 1) - 'a'] > i
            ) {
                char deleted = stack.charAt(stack.length() - 1);
                visited[deleted - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }

            stack.append(curr);
            visited[curr - 'a'] = true;
        }

        return stack.toString();
    }
}
