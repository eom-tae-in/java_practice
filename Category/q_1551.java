package Category;

import java.io.*;
import java.util.StringTokenizer;

public class q_1551 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), ",");

        for (int i = 0; i < N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0, t = N; i < T; i++){


            for (int j = 0; j < t-1; j++) {

                arr[j] = arr[j + 1] - arr[j];
            }
            t--;
        }

        for (int i = 0; i < N - T; i++) {

            if(i < N - T - 1) {

                System.out.print(arr[i] + ",");
            }
            else {
                System.out.print(arr[i]);

            }
        }

    }
}
