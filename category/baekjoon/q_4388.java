package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_4388 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals("0") && B.equals("0")) {
                break;
            }
            int carrySum = 0;
            int number = Math.max(A.length(), B.length());
            String C = "";
            if (A.length() == number) {
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
            int carry = 0;
            for (int i = A.length() - 1; i >= 0; i--) {
                if ((A.charAt(i) - '0') + (B.charAt(i) - '0') + carry >= 10) {
                    carrySum++;
                }
                carry = ((A.charAt(i) - '0') + (B.charAt(i) - '0') + carry) / 10;
            }
            sb.append(carrySum).append("\n");
        }
        System.out.println(sb);
    }
}
