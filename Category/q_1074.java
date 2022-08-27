package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_1074 {

    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int length = (int)Math.pow(2, N);
        counting(length, r, c);
        System.out.println(count);

    }

    public static void counting(int length, int r, int c) {

        if (length == 1) {
            return;
        } else if (r < length / 2 && c < length / 2) {
            counting(length / 2, r, c);
        } else if (r < length / 2 && c >= length / 2) {
            count += length / 2 * length/2;
            counting(length / 2, r, c - length / 2);
        } else if (r >= length / 2 && c < length / 2) {
            count += length / 2 * length / 2 * 2;
            counting(length / 2, r - length / 2, c);
        } else if (r >= length / 2 && c >= length / 2) {
            count += length / 2 * length / 2 * 3;
            counting(length / 2, r - length / 2, c - length / 2);
        }
    }
}
