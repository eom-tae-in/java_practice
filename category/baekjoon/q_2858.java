package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2858 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int R = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int sum = R + B;
        int A = (int)Math.sqrt(sum);

        int[] W = new int[A];
        int[] L = new int[A];
        int N = 0;

        for (int i = 3; i <= Math.sqrt(sum); i++){

            if (sum % i == 0){

                W[N] = i;
                L[N] = sum / i;
                N++;
            }
        }
        for (int i = 0; i < N; i++){

            if ((R + 4) / 2 == L[i] + W[i]){

                System.out.println(L[i] + " " + W[i]);
                break; // 정답이 유일한 경우만 있다는 가정이 있어서 break를 쓴 것이다.
            }
        }
    }
}
