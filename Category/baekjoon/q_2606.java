package Category.baekjoon;

import java.util.Scanner;

public class q_2606 {

    static boolean[] ch;
    static int[][] arr;
    static int count = 0;
    static int num, conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();
        conn = sc.nextInt();
        ch = new boolean[num + 1];
        arr = new int[num + 1][num + 1];
        for (int i = 0; i < conn; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count - 1);
    }

    public static void dfs(int start) {
        ch[start] = true;
        count++;
        for (int i = 0; i < num + 1; i++) {
            if (arr[start][i] == 1 && !ch[i]) {
                dfs(i);
            }
        }
    }
}
