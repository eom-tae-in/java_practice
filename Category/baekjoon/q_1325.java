package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class q_1325 {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] check;
    static int[] result;

    public static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = true;
        while (!queue.isEmpty()) {
            int cv = queue.poll();
            for (int i : graph.get(cv)) {
                if (!check[i]) {
                    check[i] = true;
                    queue.add(i);
                    result[i]++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        check = new boolean[n + 1];
        result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        for (int i = 1; i <= n; i++) {
            bfs(i);
            Arrays.fill(check, false);
        }
        for (int i = 1; i <= n; i++) {
            if (result[i] > max) {
                max = result[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if (max == result[i]) {
                System.out.print(i + " ");
            }
        }
    }
}

