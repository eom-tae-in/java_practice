package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_5086 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        
        while(true){

            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A == 0 && B == 0){
                break;
            }

            if(B % A == 0){
                sb.append("factor").append("\n");
            }
            else if (A % B == 0){
                sb.append("multiple").append("\n");
            }
            else{
                sb.append("neither").append("\n");
            }
        }

        System.out.println(sb);
    }
}
