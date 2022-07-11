package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2225 {

    static long A[][] = new long[201][201];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i<201; i++){
            A[i][0] = 1;
            A[1][i] = 1;
        }

        for(int i=1; i<201; i++){
            A[2][i] = i+1;
        }

        for(int i=3; i<201; i++) {
            for(int j=1; j<201; j++)
            {
                for(int k=0; k<=j; k++){
                    A[i][j]+= A[i-1][j-k] % 1000000000;
                }
            }
        }
        System.out.println(A[K][N]%1000000000);
    }
}

