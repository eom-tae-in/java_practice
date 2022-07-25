package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_7510 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[3];

        for (int i = 0; i < T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 3; j++) {

                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            if (Math.pow(arr[0],2)+ Math.pow(arr[1],2) == Math.pow(arr[2], 2)){

                sb.append("Scenario #").append(i + 1).append(":").append("\n").append("yes").append("\n").append("\n");
            }
            else {
                sb.append("Scenario #").append(i + 1).append(":").append("\n").append("no").append("\n").append("\n");
            }
        }

        System.out.println(sb);

    }
}
