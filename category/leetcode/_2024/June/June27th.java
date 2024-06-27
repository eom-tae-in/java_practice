package category.leetcode._2024.June;

import java.util.ArrayList;
import java.util.List;

public class June27th {

    public int findCenter(final int[][] edges) {
        List<Integer> nodes = new ArrayList<>();
        nodes.add(edges[0][0]);
        nodes.add(edges[0][1]);

        return nodes.contains(edges[1][0]) ? edges[1][0] : edges[1][1];
    }
}
