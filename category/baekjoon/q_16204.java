package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_16204 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int sum = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int price = 0;

        if(A == 0){

            price = sum - B;

        }

        else if (B == 0){

            price = sum - A;
        }

        else if (A - B < 0){

            price = sum - B + A;
        }

        else if (A == B){

            price = sum;
        }
        else {

            price = B + sum - A;
        }

        System.out.println(price);
    }
}
