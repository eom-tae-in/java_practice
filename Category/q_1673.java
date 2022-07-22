package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1673 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A <= 1 || B <= 1 || A >= 1000000000 || B >= 1000000000){
                break;
            }

            int sum = A;
            int r = A / B;

            while (r >= B){

                sum += r;

                r /= B;
            }
            sum += r;

            System.out.println(sum);
        }


    }
}
