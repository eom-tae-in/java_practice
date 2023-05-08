package Category.baekjoon;

import java.util.*;

public class q_1260 {

    static ArrayList<ArrayList<Integer>> graph;
    static int N, M, V;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        graph = new ArrayList<>();
        check = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(V);
        System.out.println();
        Arrays.fill(check, false);
        bfs(V);
    }

    public static void dfs(int n) {
        check[n] = true;
        System.out.print(n + " ");
        for (int i : graph.get(n)) {
            if (!check[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {

        check[n] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            System.out.print(cv + " ");
            for (int i : graph.get(cv)) {
                if (!check[i]) {
                    queue.add(i);
                    check[i] = true;
                }
            }
        }
    }
}
