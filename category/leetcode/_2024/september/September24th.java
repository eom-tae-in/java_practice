package category.leetcode._2024.september;

public class September24th {

    public int longestCommonPrefix(final int[] arr1, final int[] arr2) {
        int answer = 0;
        Trie trie = new Trie();
        for (int num : arr1) {
            trie.insert(Integer.toString(num));
        }
        for (int num : arr2) {
            answer = Math.max(answer, trie.search(Integer.toString(num)));
        }

        return answer;
    }

    private static class Trie {

        private final TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(final String word) {
            TrieNode trieNode = root;
            for (char ch : word.toCharArray()) {
                int path = ch - '0';
                TrieNode[] children = trieNode.getChildren();
                if (children[path] == null) {
                    children[path] = new TrieNode();
                }
                trieNode = children[path];
            }
        }

        int search(final String word) {
            int pathDepth = 0;
            TrieNode trieNode = root;
            for (char ch : word.toCharArray()) {
                int path = ch - '0';
                TrieNode[] children = trieNode.getChildren();
                if (children[path] == null) {
                    break;
                }
                trieNode = children[path];
                pathDepth++;
            }

            return pathDepth;
        }

        private static class TrieNode {

            private final TrieNode[] children;

            TrieNode() {
                children = new TrieNode[10];
            }

            TrieNode[] getChildren() {
                return children;
            }
        }
    }
}
