package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_2484 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[] sum = new int[4];

        int[] arr = new int[4];

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 4; j++){

                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int count = 0;

            for (int k = 0; k < 3; k++){

                if(arr[k] == arr[k+1]){

                    count++;

                    if (count == 3){
                        sum[i] += 50000 + arr[0] * 5000;
                    }
                }
                else {
                    if (count == 2){

                        sum[i] += 10000 + arr[1] * 1000;

                    }
                    else if (arr[0] == arr[1] && arr[2] == arr[3]){

                        sum[i] += 2000 + arr[0] * 500 + arr[2] * 500;

                    }
                    else if(arr[0] == arr[1]){

                        sum[i] += 1000 + arr[0] * 100;
                    }
                    else if (arr[1] == arr[2]){

                        sum[i] += 1000 + arr[1] * 100;
                    }
                    else if (arr[2] == arr[3]){

                        sum[i] += 1000 + arr[2] * 100;
                    }
                }
            }
            if (count == 0){

                sum[i] += arr[3] * 100;
            }
        }

        Arrays.sort(sum);

        System.out.println(sum[3]);
    }
}
