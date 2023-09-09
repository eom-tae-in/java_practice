package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_25304 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Sum = Integer.parseInt(br.readLine());
        int Sc = 0;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++){

            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int price = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            Sc += price * number;
        }

        if (Sc == Sum){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }


    }
}
