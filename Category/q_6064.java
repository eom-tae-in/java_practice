package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_6064 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int j = 0;

        for(int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int count = 0;

            if(x == y){

                count = x;
            }
            else {

                int A = Math.max(M, N) % Math.min(M, N);

                if (Math.min(M, N) == M) {

                    for (j = 0; x != y; j++) {

                        x = (M + x - A) % M;

                        if(j * N + y >  M * N / gcd(M, N)){

                            count = -1;
                            break;
                        }
                    }
                    if (count != -1) {

                        count = j * N + y;
                    }
                }

                else {
                    for (j = 0; y != x; j++) {

                        y = (N + y - A) % N;


                        if (j * M + x > M * N / gcd(M, N)) {

                            count = -1;
                            break;
                        }
                    }

                    if (count != -1) {

                        count = j * M + x;

                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    public static int gcd(int n1, int n2) {
        if (n2 == 0)
            return n1;
        return gcd(n2, n1 % n2);
    }
}


