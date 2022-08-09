package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_2420 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] arr = new long[2];

        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        System.out.println(arr[1] - arr[0]);
    }
}
