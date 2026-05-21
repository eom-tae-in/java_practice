package category.leetcode._2026.may;

public class May21st {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        int answer = 0;

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

        private Trie() {
            root = new TrieNode();
        }

        private void insert(String word) {
            TrieNode curr = root;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - '0'] == null) {
                    curr.children[ch - '0'] = new TrieNode();
                }

                curr = curr.children[ch - '0'];
            }
        }

        private int search(String word) {
            TrieNode curr = root;
            int depth = 0;

            for (char ch : word.toCharArray()) {
                if (curr.children[ch - '0'] == null) {
                    break;
                }

                curr = curr.children[ch - '0'];
                depth++;
            }

            return depth;
        }


        private static class TrieNode {

            private final TrieNode[] children;

            private TrieNode() {
                children = new TrieNode[10];
            }
        }
    }
}
