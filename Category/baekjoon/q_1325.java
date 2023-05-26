package Category.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class q_1325 {

    static boolean[] check;
    static ArrayList<ArrayList<Integer>> graph;
    static int max = Integer.MIN_VALUE;

    public static void dfs(int num) {
        check[num] = true;
        for (int i : graph.get(num)) {
            if (!check[i]) {
                dfs(i);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        check = new boolean[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(check, false);
            dfs(i);
        }
    }

}
