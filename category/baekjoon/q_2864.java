package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2864 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();

        input = input.replace("6", "5");

        StringTokenizer st = new StringTokenizer(input);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        sb.append(a + b).append(" ");

        input = input.replace("5", "6");

        st = new StringTokenizer(input);

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        sb.append(a + b);
        System.out.print(sb);
    }
}

