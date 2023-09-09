package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1297 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        double dia = Math.sqrt(Math.pow(H, 2) + Math.pow(W, 2));

        double uni = D / dia;

        H = (int)(uni * H);
        W = (int)(uni * W);

        System.out.println(H + " " + W);
    }
}
