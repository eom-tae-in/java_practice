package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_10101 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (arr[0] == 60 && arr[1] == 60 && arr[2] == 60) {
            System.out.println("Equilateral");
        } else if (arr[0] + arr[1] + arr[2] == 180) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (arr[i] == arr[j]) {
                        System.out.println("Isosceles");
                        return;
                    }
                }
            }
            System.out.println("Scalene");
        } else {
            System.out.println("Error");
        }
    }
}
