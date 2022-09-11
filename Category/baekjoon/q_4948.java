package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_4948 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while (true){

            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                break;
            }

            int value = prime(N);

            sb.append(value).append("\n");

        }

        System.out.println(sb);

    }

    public static int prime(int N){

        int count = 0;

        if(N == 1){
            return 1;
        }
        if(N == 2){
            return 1;
        }

        for(int i = N+1; i <= 2 * N;i++){
            for(int j =2; j <= Math.sqrt(i); j++){

                if(i%j ==0){
                    break;
                }
                if(j == (int)Math.sqrt(i)){
                    count++;
                }
            }
        }
        return count;
    }
}
