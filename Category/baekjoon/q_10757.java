package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_10757 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String a = st.nextToken();
        String b = st.nextToken();

        int max = Math.max(a.length(),b.length());

        int[] A = new int[max +1];
        int[] B = new int[max +1];

        for(int i = a.length()-1, j = 0; i >= 0; i--, j++){

            A[j] = a.charAt(i) - '0';
        }

        for(int i = b.length()-1, j = 0; i >= 0; i--, j++){

            B[j] = b.charAt(i) - '0';
        }

        for(int i = 0; i < max; i++){

            int sum = A[i] + B[i];

            A[i] = sum % 10;
            A[i+1] += sum / 10;

        }
        int fi =0;
        StringBuilder sb = new StringBuilder();

        if(A[max] != 0){

            fi = max;
        }
        else{
            fi = max - 1;
        }

        for(int i = fi; i >=0;  i--){

            sb.append(A[i]);
        }
        System.out.println(sb);
    }
}
