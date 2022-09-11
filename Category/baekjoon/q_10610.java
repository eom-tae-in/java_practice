package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q_10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();

        StringBuilder sb = new StringBuilder();

        char[] A = T.toCharArray();
        Arrays.sort(A); // 오름차순

        int sum = 0;

        for(int i = T.length() - 1; i >= 0; i--) {
            int num = A[i] - '0';
            sum += num;
            sb.append(num);

        }

        if (sum % 3 == 0 && A[0] == '0'){

            System.out.println(sb);
        }

        else {

            System.out.println(-1);
        }
    }
}


