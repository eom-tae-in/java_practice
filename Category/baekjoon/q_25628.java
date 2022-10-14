package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_25628 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bread = Integer.parseInt(st.nextToken());
        int patty = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(bread / 2, patty));
    }
}
