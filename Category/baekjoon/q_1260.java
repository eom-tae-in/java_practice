package Category.baekjoon;

import java.util.*;

public class q_1260 {

    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<Integer> dfsArr;
    static ArrayList<Integer> bfsArr;
    static int N, M, V;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new ArrayList<>();
        check = new boolean[N + 1];
        bfsArr = new ArrayList<>();
        dfsArr = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }
        check[V] = true;
        dfsArr.add(V);
        dfs(V);
        Arrays.fill(check, false);
        bfs(V);
        System.out.println(dfsArr);
        System.out.println(bfsArr);
    }

    public static void dfs(int n) {

        for (int i : graph.get(n)) {
            if (!check[i]){
                dfsArr.add(i);
                check[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {

        check[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        bfsArr.add(n);
        while (!queue.isEmpty()) {
            for (int i : graph.get(queue.poll())) {
                if (!check[i]) {
                    queue.add(i);
                    check[i] = true;
                    bfsArr.add(i);
                }
            }
        }
    }
}
