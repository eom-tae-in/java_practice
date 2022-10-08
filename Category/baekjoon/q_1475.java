package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q_1475 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] arr = new int[9]; //0 ~ 8

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) - '0' == 6 || str.charAt(i) - '0' == 9) {
                arr[6]++;
            } else {
                arr[str.charAt(i) - '0']++;
            }
        }
        if (arr[6] % 2 == 1) {
            arr[6] = arr[6] / 2 + 1;
        } else {
            arr[6] /= 2;
        }
        Arrays.sort(arr);
        System.out.println(arr[8]);
    }
}
