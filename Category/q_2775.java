package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2775 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] sum = new int[15][15];

        for(int i = 0; i < 15; i++){

            sum[i][1] = 1;
            sum[0][i] = i;
        }

        for(int i = 1; i < 15; i++){

            for (int j = 1; j < 15; j++){

                sum[i][j] = sum[i-1][j] + sum[i][j-1];
            }
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){

            int floor = Integer.parseInt(br.readLine());
            int num = Integer.parseInt(br.readLine());

            sb.append(sum[floor][num]).append("\n");
        }

        System.out.println(sb);

    }
}

