package category.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q_2606 {

    static boolean[] ch;

    static int[][] connection;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int conn = sc.nextInt();
        ch = new boolean[num + 1];
        connection = new int[conn][2];
        for (int i = 0; i < conn; i++) {
            connection[i][0] = sc.nextInt();
            connection[i][1] = sc.nextInt();
        }
        bfs();
        System.out.println(count);
    }

    public static void bfs() {
        ch[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < connection.length; i++) {
            if (connection[i][0] == 1) {
                queue.add(connection[i][1]);
            }
        }
        while (!queue.isEmpty()) {
            int current = queue.remove();
            ch[current] = true;
            count++;
            for (int i = 0; i < connection.length; i++) {
                if (connection[i][0] == current && !ch[connection[i][1]]) {
                    queue.add(connection[i][1]);
                    System.out.println(connection[i][1]);
                }
            }
        }
    }
}
