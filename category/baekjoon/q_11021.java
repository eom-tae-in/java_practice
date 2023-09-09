package category.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class q_11021 {
    public static void main(String args[]) throws IOException {

        BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(sc.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= a; i++) {
            String str = sc.readLine();
            sb.append("Case #").append(i).append(": ")
                    .append(str.charAt(0)-'0'+str.charAt(2)-'0').append('\n');
        }
        System.out.println(sb);
    }
}
