package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1085 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] A = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < 4; i++){

            A[i] = Integer.parseInt(st.nextToken());
        }

        A[2] -= A[0];
        A[3] -= A[1];

        Arrays.sort(A);

        System.out.println(A[0]);
    }
}
