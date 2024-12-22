package category.leetcode._2024.december;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class December22nd {

    public int[] leftmostBuildingQueries(final int[] heights, final int[][] queries) {
        IndexedQuery[] indexedQueries = getIndexedQueries(queries);
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);
        List<Integer> stack = new ArrayList<>();

        int heightsIndex = heights.length - 1;
        for (IndexedQuery indexedQuery : indexedQueries) {
            int queryIndex = indexedQuery.queryIndex;
            int a = indexedQuery.a;
            int b = indexedQuery.b;
            if (a == b || heights[a] < heights[b]) {
                answer[queryIndex] = b;
            } else {
                while (heightsIndex > b) {
                    while (!stack.isEmpty() && heights[stack.get(stack.size() - 1)] <= heights[heightsIndex]) {
                        stack.remove(stack.size() - 1);
                    }
                    stack.add(heightsIndex--);
                }
                int j = lastGreater(stack, a, heights);
                if (j != -1) {
                    answer[queryIndex] = stack.get(j);
                }
            }
        }

        return answer;
    }

    private record IndexedQuery(
            int queryIndex,
            int a,
            int b
    ) {
    }

    private int lastGreater(
            final List<Integer> list,
            final int target,
            final int[] heights
    ) {
        int l = -1;
        int r = list.size() - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (heights[list.get(m)] > heights[target]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private IndexedQuery[] getIndexedQueries(final int[][] queries) {
        IndexedQuery[] indexedQueries = new IndexedQuery[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int a = Math.min(queries[i][0], queries[i][1]);
            int b = Math.max(queries[i][0], queries[i][1]);
            indexedQueries[i] = new IndexedQuery(i, a, b);
        }
        Arrays.sort(indexedQueries, (a, b) -> Integer.compare(b.b, a.b));

        return indexedQueries;
    }
}
