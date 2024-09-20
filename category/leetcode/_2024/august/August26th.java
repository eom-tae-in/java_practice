package category.leetcode._2024.august;

import java.util.ArrayList;
import java.util.List;

public class August26th {

    public List<Integer> postorder(final Node root) {
        ArrayList<Integer> answer = new ArrayList<>();
        postorder(root, answer);

        return answer;
    }

    void postorder(final Node root, final ArrayList<Integer> answer) {
        if (root != null) {
            for (Node node : root.children) {
                postorder(node, answer);
            }
            answer.add(root.val);
        }
    }

    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(final int _val) {
            val = _val;
        }

        public Node(final int _val, final List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
