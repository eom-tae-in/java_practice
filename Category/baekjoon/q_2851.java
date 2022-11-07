package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_2851 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] mushrooms = new int[10];

        for (int i = 0; i < 10; i++) {
            mushrooms[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int current = 0;

        for (int i = 0; i < mushrooms.length; i++) {
            sum += mushrooms[i];
            current = mushrooms[i];
            if (sum >= 100) {
                break;
            }
        }

        if (100 - (sum - current) == sum - 100) {
            System.out.println(sum);
            return;
        }
        int a = Math.min(100 - (sum - current), sum - 100);

        if (a == 100 - (sum - current)) {
            System.out.println(sum - current);
        }
        else {
            System.out.println(sum);
        }




    }
}
