package Category.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q_11724 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;

    public static void dfs(int n) {
        if (check[n]) {
            return;
        }
        check[n] = true;
        for (int i : graph.get(n)) {
            if (!check[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int count = 0;
        graph = new ArrayList<>();
        check = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <= V; i++) {
            if (!check[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
