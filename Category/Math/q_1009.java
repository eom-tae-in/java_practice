package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1009 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine()," ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int z = A;

            if (B == 1){

                z = A % 10;
            }

            for (int j = 1; j < B; j++){

                z = (z * A) % 10; // z *= A % 10으로 쓰면 A % 10이 먼저 계산이 된다.
            }

            if (z == 0){

                z = 10;
            }

            sb.append(z).append("\n");

        }

        System.out.println(sb);
    }
}
