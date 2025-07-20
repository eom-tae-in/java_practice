package category.leetcode._2025.july;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class July20th {

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();

        paths.sort(Comparator.<List<String>>comparingInt(List::size).thenComparing((a, b) -> {
            int loopCount = a.size();

            for (int i = 0; i < loopCount; i++) {
                int result = a.get(i).compareTo(b.get(i));

                if (result != 0) {
                    return result;
                }
            }

            return 0;
        }));

        for (List<String> path : paths) {
            TrieNode curr = root;

            for (String s : path) {
                curr.children.putIfAbsent(s, new TrieNode());
                curr = curr.children.get(s);
            }
        }

        Map<String, List<TrieNode>> subtreeToNodes = new HashMap<>();
        buildSubtreeToNodes(root, subtreeToNodes);

        for (List<TrieNode> nodes : subtreeToNodes.values()) {
            if (nodes.size() > 1) {
                for (TrieNode trieNode : nodes) {
                    trieNode.isDeleted = true;
                }
            }
        }

        List<List<String>> answer = new ArrayList<>();
        constructPath(root, new ArrayList<>(), answer);

        return answer;
    }

    private String buildSubtreeToNodes(TrieNode trieNode, Map<String, List<TrieNode>> subtreeToNodes) {
        StringBuilder stringBuilder = new StringBuilder("(");

        for (String s : trieNode.children.keySet()) {
            TrieNode child = trieNode.children.get(s);
            stringBuilder.append(s).append(buildSubtreeToNodes(child, subtreeToNodes));
        }

        stringBuilder.append(")");
        String subtree = stringBuilder.toString();

        if (!subtree.equals("()")) {
            subtreeToNodes.putIfAbsent(subtree, new ArrayList());
            subtreeToNodes.get(subtree).add(trieNode);
        }

        return subtree;
    }

    private void constructPath(TrieNode trieNode, List<String> current, List<List<String>> answer) {
        for (String s : trieNode.children.keySet()) {
            TrieNode child = trieNode.children.get(s);

            if (!child.isDeleted) {
                current.add(s);
                constructPath(child, current, answer);
                current.remove(current.size() - 1);
            }
        }

        if (!current.isEmpty()) {
            answer.add(new ArrayList<>(current));
        }
    }

    private static class TrieNode {
        private final Map<String, TrieNode> children;
        private boolean isDeleted;

        private TrieNode() {
            children = new HashMap<>();
            isDeleted = false;
        }
    }
}
