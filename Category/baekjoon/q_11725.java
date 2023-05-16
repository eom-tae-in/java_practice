package Category.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q_11725 {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] parentInfo;
    static boolean[] check;

    public static void dfs(int n) {
        check[n] = true;
        for (int i : graph.get(n)) {
            if (parentInfo[i] == 0 && !check[i]) {
                parentInfo[i] = n;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        graph = new ArrayList<>();
        parentInfo = new int[n + 1];
        check = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(1);
        for (int i : parentInfo) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }
}
