package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q_11653 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= Math.sqrt(T);i++){

            while (T % i == 0) {

                if(T % i ==1){

                    sb.append(i);
                }

                sb.append(i).append("\n");

                T /= i;
            }
        }
        if(T != 1){
            sb.append(T);
        }

        System.out.println(sb);
    }
}
