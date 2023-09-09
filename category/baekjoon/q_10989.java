package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[10001];

        int index = Integer.parseInt(br.readLine());

        for (int i = 0; i < index; i++) {
            array[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            while (array[i] > 0){
                sb.append(i).append("\n");
                array[i]--;
            }
        }
        System.out.println(sb);
    }
}
