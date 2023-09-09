package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1252 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        String C = "";


        int digit = Math.max(A.length(), B.length());

        if (digit == A.length()) {
            for (int i = 0; i < A.length() - B.length(); i++) {
                C += "0";
            }
            B = C + B;
        } else {
            for (int i = 0; i < B.length() - A.length(); i++) {
                C += "0";
            }
            A = C + A;
        }

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '1' || B.charAt(i) == '1') {
                break;
            }
            if (i == A.length() - 1) {
                System.out.println(0);
                return;
            }
        }

        int carry = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = A.length()-1; i >= 0; i--) {

            sb.append(((A.charAt(i) - '0') + (B.charAt(i) - '0') + carry) % 2);

            if ((A.charAt(i) - '0') + (B.charAt(i) - '0') + carry > 1) {
                carry = 1;
                if (i == 0) {
                    sb.append(1);
                }
            } else {
                carry = 0;
            }

        }
        sb.reverse();
        String str = String.valueOf(sb);

        boolean price = false;
        while (true) {
            if (str.charAt(0) == '1') {
                price = true;
                break;
            } else {
                if (!price) {
                    str = str.substring(1);
                }
            }
        }
        System.out.println(str);
    }
}
