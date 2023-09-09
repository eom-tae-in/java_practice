package category.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_14487 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        Arrays.sort(arr);

        System.out.println(sum - arr[T-1]);
    }
}
