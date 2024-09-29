package category.leetcode._2024.september;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class September29th {

    private static class AllOne {

        private final Map<String, Node> map;
        private final Node head;
        private final Node tail;

        public AllOne() {
            map = new HashMap<>();
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        public void inc(final String key) {
            if (map.containsKey(key)) {
                increaseKeyCount(key);
            } else {
                addNewKey(key);
            }

        }

        private void increaseKeyCount(final String key) {
            Node node = map.get(key);
            node.keys.remove(key);
            if (node.next == tail || node.next.count != node.count + 1) {
                insertNext(node, new Node(node.count + 1));
            }
            node.next.keys.add(key);
            map.put(key, node.next);

            if (node.keys.isEmpty()) {
                remove(node);
            }
        }

        private void insertNext(final Node node, final Node newNode) {
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }

        private void remove(final Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addNewKey(final String key) {
            if (head.next.count == 1) {
                head.next.keys.add(key);
            } else {
                insertNext(head, new Node(1, key));
            }
            map.put(key, head.next);
        }

        // 감소시키는 기능은 매개변수로 넘어온 key값이 무조건 있다고 가정함
        public void dec(final String key) {
            Node node = map.get(key);
            node.keys.remove(key);
            if (node.count > 1) {
                if (node.prev == head || node.prev.count != node.count - 1) {
                    insertNext(node.prev, new Node(node.count - 1));
                }
                node.prev.keys.add(key);
                map.put(key, node.prev);
            } else {
                map.remove(key);
            }

            if (node.keys.isEmpty()) {
                remove(node);
            }
        }

        public String getMaxKey() {
            if (head.next == tail) {
                return "";
            }
            return tail.prev.keys.iterator().next();
        }

        public String getMinKey() {
            if (tail.prev == head) {
                return "";
            }
            return head.next.keys.iterator().next();
        }

        private static class Node {

            private Node prev;
            private Node next;
            private final int count;
            private final Set<String> keys;

            public Node(final int count) {
                this.count = count;
                this.keys = new HashSet<>();
            }

            public Node(final int count, final String key) {
                this.count = count;
                this.keys = new HashSet<>();
                keys.add(key);
            }
        }
    }
}

