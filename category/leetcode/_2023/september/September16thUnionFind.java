package category.leetcode._2023.september;

import java.util.Arrays;
import java.util.Comparator;

public class September16thUnionFind {

    public int minimumEffortPath(int[][] heights) {
        int rowSize = heights.length;
        int columnSize = heights[0].length;

        // 2차원 배열을 1차원 배열로 바꾸고 edge의 요소(start, end, effort)들을 저장하기 위한 2차원 배열 생성
        int[][] edges = new int[(rowSize - 1) * columnSize + (columnSize - 1) * rowSize][3];

        // edges 배열의 row 인덱스를 담당하는 변수
        int count = 0;

        /*
          edge들의 초기 상태 세팅 && 오른쪽과 아래쪽만 edge를 생성하는 이유는 최소한의 노력을 구하는 것이기 때문에
          왼쪽 위에서 오른쪽 아래로 내려갈 때의 드는 노력의 최소 값을 구하는 건데 왼쪽과 위쪽으로 향하는 edge를 고려할 필요가 없다.
         */
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                int currentNode = i * columnSize + j;
                if (j + 1 < columnSize) {
                    edges[count++] = new int[]{currentNode, currentNode + 1,
                            Math.abs(heights[i][j] - heights[i][j + 1])};
                }
                if (i + 1 < rowSize) {
                    edges[count++] = new int[]{currentNode, currentNode + columnSize,
                            Math.abs(heights[i][j] - heights[i + 1][j])};
                }
            }
        }

        // edge들을 effort가 낮은 순서대로 정렬한다.
        Arrays.sort(edges, Comparator.comparingInt(edge -> edge[2]));

        // 자기 자신을 root 가지는 노드들의 부모를 가르키는 초기 배열 생성, 이 배열의 크기는 heights의 전체 크기와 같다.
        int[] parent = new int[rowSize * columnSize];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int startNode = edge[0];
            int endNode = edge[1];
            int startRoot = find(parent, startNode);
            int endRoot = find(parent, endNode);
            /*
              startRoot, endRoot 각각의 부모를 찾은 다음 이 부모가 다르다면 서로 다른 집합에 속해있는 것이므로 이를 연결시켜줘야 한다.
              이 문제에서는 effort가 작은 순서대로 정렬하고 edge들이 서로 다른 집합인 경우 이를 연결시켜주다가
              처음으로 처음 위치와 끝 위치가 서로 연결되는 순간이 가장 작은 effort가 드는 상황이다.
              그래서 startRoot와 endRoot가 다른 경우 이를 연결 시켜줘야한다.
              startRoot를 endRoot로 변경(왼쪽 상단에서 오른쪽 하단으로 이동하기 때문)
             */
            if (startRoot != endRoot) {
                parent[startRoot] = endRoot;
                /*
                  만약 서로 다른 집합에 속해있었다면 처음 위치와 끝 위치가 연결되었을 가능성이 존재하게 된다.
                  그렇기 때문에 if문 로직을 탈 때 마다 처음 위치의 부모와 끝 위치의 부모가 일치하는 지 확인한다.
                  일치한다면 현재 edge가 최소 effort인 것이다.
                 */
                if (find(parent, parent[0]) == find(parent, parent[rowSize * columnSize - 1])) {
                    return edge[2];
                }
            }
        }
        return 0;
    }

    private int find(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }
}
