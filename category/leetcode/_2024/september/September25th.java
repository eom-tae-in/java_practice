package category.leetcode._2024.september;

public class September25th {

    public int[] sumPrefixScores(final String[] words) {
        int n = words.length;
        int[] answers = new int[n];
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < n; i++) {
            answers[i] = trie.getScore(words[i]);
        }

        return answers;
    }

    private static class Trie {

        private final TrieNode root;

        private Trie() {
            root = new TrieNode();
        }

        private void insert(final String word) {
            TrieNode trieNode = root;
            for (char ch : word.toCharArray()) {
                int path = ch - 'a';
                TrieNode[] children = trieNode.getChildren();
                if (children[path] == null) {
                    children[path] = new TrieNode();
                }
                trieNode = children[path];
                trieNode.increaseCount();
            }
        }

        private int getScore(final String word) {
            TrieNode trieNode = root;
            int scoreSum = 0;
            for (char ch : word.toCharArray()) {
                int path = ch - 'a';
                TrieNode[] children = trieNode.getChildren();
                scoreSum += children[path].getCount();
                trieNode = children[path];
            }

            return scoreSum;
        }

        private static class TrieNode {

            private final TrieNode[] children;
            private int count;

            private TrieNode() {
                children = new TrieNode[26];
                count = 0;
            }

            private TrieNode[] getChildren() {
                return children;
            }

            private int getCount() {
                return count;
            }

            private void increaseCount() {
                count++;
            }
        }
    }
}
