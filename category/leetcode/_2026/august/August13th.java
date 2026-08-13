package category.leetcode._2026.august;

public class August13th {

    private char[] chars;
    private Node[] tree;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        chars = s.toCharArray();
        int sLen = s.length();
        tree = new Node[sLen * 4];
        build(1, 0, sLen - 1);
        int queryLen = queryIndices.length;
        int[] answer = new int[queryLen];

        for (int i = 0; i < queryLen; i++) {
            int currIdx = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            if (chars[currIdx] != newChar) {
                chars[currIdx] = newChar;
                update(1, 0, sLen - 1, currIdx);
            }

            answer[i] = tree[1].maxLen;
        }

        return answer;
    }

    private void update(int node, int start, int end, int target) {
        if (start == end) {
            tree[node] = new Node(chars[target]);

            return;
        }

        int mid = (start + end) / 2;

        if (target <= mid) {
            update(node * 2, start, mid, target);
        } else {
            update(node * 2 + 1, mid + 1, end, target);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void build(int node, int start, int end) {
        if (start == end) {
            tree[node] = new Node(chars[start]);

            return;
        }

        int mid = (start + end) / 2;
        build(node * 2, start, mid);
        build(node * 2 + 1, mid + 1, end);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node merge(Node left, Node right) {
        Node merge = new Node();
        merge.totalLen = left.totalLen + right.totalLen;
        merge.prefixLen = left.prefixLen;
        merge.suffixLen = right.suffixLen;
        merge.maxLen = Math.max(left.maxLen, right.maxLen);
        merge.prefixChar = left.prefixChar;
        merge.suffixChar = right.suffixChar;

        if (left.suffixChar == right.prefixChar) {
            int connectedLen = left.suffixLen + right.prefixLen;
            merge.maxLen = Math.max(merge.maxLen, connectedLen);

            if (left.prefixLen == left.totalLen) {
                merge.prefixLen = left.totalLen + right.prefixLen;
            }

            if (right.suffixLen == right.totalLen) {
                merge.suffixLen = right.totalLen + left.suffixLen;
            }
        }

        return merge;
    }

    private static class Node {

        private int totalLen;
        private int prefixLen;
        private int suffixLen;
        private int maxLen;
        private char prefixChar;
        private char suffixChar;

        private Node(char ch) {
            totalLen = 1;
            prefixLen = 1;
            suffixLen = 1;
            maxLen = 1;
            prefixChar = ch;
            suffixChar = ch;
        }

        private Node() {

        }
    }
}
