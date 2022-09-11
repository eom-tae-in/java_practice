package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_10162 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = T / 300;
        int B = (T % 300) / 60;
        int C = ((T % 300) % 60) / 10;

        if (((T % 300) % 60) % 10 != 0){
            System.out.println(-1);
        }
        else {
            System.out.println(A+" "+B+" "+C);
        }
    }
}
