package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1189 {

    static int R;
    static int C;
    static int K;

    static int[][] map;
    static int[][] visit;

    static int[] Rmove = {1, -1, 0, 0}; // 아래, 위, 오른쪽, 왼쪽 순으로 진행
    static int[] Cmove = {0, 0, 1, -1};
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int [R][C];
        visit = new int[R][C];

        for (int i = 0; i < R; i++) {

            String s = br.readLine();
            for (int j = 0; j < C; j++) {

                map[i][j] = s.charAt(j);
            }
        }

        visit[R - 1][0] = 1; // 시작지점을 1로 초기화시킴
        moving(R - 1, 0, 1);
        System.out.println(count);


    }

    static void moving(int r, int c, int k) {

        if (r == 0 && c == C - 1) {
            if (k == K) {
                count++;
                return;
            }
        }

        for (int i = 0; i < 4; i++) {

            int Rlocate = r + Rmove[i];
            int Clocate = c + Cmove[i];
            if (Rlocate < 0 || Rlocate >= R || Clocate < 0 || Clocate >= C) {
                continue;
            }
            if (visit[Rlocate][Clocate] == 1 || map[Rlocate][Clocate] == 'T') {
                continue;
            }
            visit[Rlocate][Clocate] = 1;
            moving(Rlocate, Clocate,k+1);
            visit[Rlocate][Clocate] = 0; // return문이 동작해야 실행이 된다.
        }
    }
}
