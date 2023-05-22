package Category.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q_2644 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] check;
    static int x, y, result = -1;

    public static void dfs(int start, int end, int cnt) {
        if (start == end) {
            result = cnt;
            return;
        }
        check[start] = true;
        for (int i : graph.get(start)) {
            if (!check[i]) {
                dfs(i, end, cnt + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        graph = new ArrayList<>();
        check = new boolean[num + 1];
        for (int i = 0; i <= num; i++) {
            graph.add(new ArrayList<>());
        }
        x = sc.nextInt();
        y = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        dfs(x, y, 0);
        System.out.println(result);
    }
}
