package category.leetcode._2024.september;

public class September23rd {

    public int minExtraChar(final String s, final String[] dictionary) {
        Node root = new Node();
        for (String word : dictionary) {
            insert(word, root);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        for (int i = 0; i < n; i++) {
            search(dp, root, s, i);
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
        }

        return dp[n];
    }

    private void insert(final String word, final Node root) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int path = ch - 'a';
            if (node.children[path] == null) {
                node.children[path] = new Node();
            }
            node = node.children[path];
        }
        node.isEnd = true;
    }

    private void search(final int[] dp, final Node root, final String s, final int index) {
        Node node = root;
        for (int i = index; i < s.length(); i++) {
            int path = s.charAt(i) - 'a';
            if (node.children[path] != null) {
                node = node.children[path];
                if (node.isEnd) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[index]);
                }
            } else {
                return;
            }
        }
    }

    private static class Node {

        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
}

