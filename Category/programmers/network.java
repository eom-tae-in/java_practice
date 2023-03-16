package Category.programmers;

import java.util.*;
import java.util.stream.Stream;

public class network {

    static boolean check[];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] computers = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                computers[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i, computers, check);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int i, int[][] computers, boolean[] check) {
        check[i] = true;
        for (int k = 0; k < computers.length; k++) {
            if (i != k && computers[i][k] == 1 && !check[k]) {
                dfs(k, computers, check);
            }
        }
    }
}
