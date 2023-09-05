package Category.leetcode.september;

import java.util.HashMap;
import java.util.Map;

class Node {
    int value;
    Node next;
    Node random;

    public Node(int value) {
        this.value = value;
        this.next = null;
        this.random = null;
    }
}

public class September5th {
    private Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node head) {

        // head가 비어있을 경우를 위한 코드
        if (head == null) {
            return null;
        }
        // map에 이미 head의 값이 존재한다면 Node를 새로 생성하지 않고 바로 반환(성능 개선)
        if (map.containsKey(head)){
            return map.get(head);
        }

        // 이 로직이 실행되는 상황이라면 이미 head는 map에 존재하지 않는 키값인 상태이다. 그래서 Node 객체를 생성하는 것이다.
        Node newNode = new Node(head.value);
        // head == newNode
        map.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
