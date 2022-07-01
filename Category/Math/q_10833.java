package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_10833 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int R = 0;

        for(int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine());

            int P = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            R += N % P;
        }

        System.out.println(R);
    }
}
