package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q_2501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int num;

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= N; i++) {

            if (N % i == 0) {
                numbers.add(i);
            }
        }
        if (numbers.size() < K) {
            num = 0;
        } else {
            num = numbers.get(K - 1);
        }
        System.out.println(num);

    }
}
