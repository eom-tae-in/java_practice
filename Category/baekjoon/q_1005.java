package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_1005 {

    static int[] time;
    static int[] timeSum;
    static ArrayList<Integer>[] list;
    static int[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            list = new ArrayList[N + 1];
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
                list[j] = new ArrayList<>();
            }

            count = new int[N + 1];

            for (int p = 0; p < K; p++) {

                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list[x].add(y);
                count[y]++;
            }

            int W = Integer.parseInt(br.readLine());

            timeSum = new int[N + 1];
            topologySort();
            sb.append(timeSum[W]).append("\n");
        }
        System.out.println(sb);


    }


    static void topologySort() {

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < count.length; i++) {

            if (count[i] == 0) {

                timeSum[i] = time[i];
                q.offer(i); // 값을 추가
            }
        }

        while (!q.isEmpty()) {
            int currentTime = q.poll(); // 첫번째 값을 반환하고 제거한다.
            for (int i = 0; i < list[currentTime].size(); i++) {

                int nextTime = list[currentTime].get(i);
                timeSum[nextTime] = Math.max(timeSum[currentTime] + time[nextTime], timeSum[nextTime]);
                count[nextTime]--;
                if (count[nextTime] == 0) {
                    q.offer(nextTime);
                }
            }
        }
    }
}
