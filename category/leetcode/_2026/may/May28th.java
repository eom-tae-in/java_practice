package category.leetcode._2026.may;

public class May28th {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie trie = new Trie();

        for (int i = 0; i < wordsContainer.length; i++) {
            trie.insert(wordsContainer[i], i);
        }

        int[] answer = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            answer[i] = trie.search(wordsQuery[i]);
        }

        return answer;
    }

    private static class Trie {

        private final TrieNode root;

        private Trie() {
            root = new TrieNode();
        }

        private void insert(String word, int idx) {
            TrieNode curr = root;
            update(curr, word.length(), idx);

            for (int i = word.length() - 1; i >= 0; i--) {
                int childIdx = word.charAt(i) - 'a';

                if (curr.children[childIdx] == null) {
                    curr.children[childIdx] = new TrieNode();
                }

                curr = curr.children[childIdx];
                update(curr, word.length(), idx);
            }
        }

        private int search(String word) {
            TrieNode curr = root;

            for (int i = word.length() - 1; i >= 0; i--) {
                int childIdx = word.charAt(i) - 'a';

                if (curr.children[childIdx] == null) {
                    break;
                }

                curr = curr.children[childIdx];
            }

            return curr.idx;
        }

        private void update(TrieNode node, int length, int idx) {
            if (length < node.length) {
                node.length = length;
                node.idx = idx;
            }
        }

        private static class TrieNode {

            private final TrieNode[] children;
            private int length;
            private int idx;

            private TrieNode() {
                children = new TrieNode[26];
                length = Integer.MAX_VALUE;
                idx = -1;
            }
        }
    }
}
