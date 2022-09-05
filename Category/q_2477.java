package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2477 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[6];
        int maximum = 0;
        int maximumNum = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int direct = Integer.parseInt(st.nextToken());
            arr[i] = Integer.parseInt(st.nextToken());;

            if (maximum < arr[i]) {

                maximum = arr[i];
                maximumNum = i;
            }
        }
        int maxNum, max, min;
        if (arr[(maximumNum - 1 + 6) % 6] < arr[(maximumNum + 1) % 6]) {
            maxNum = maximumNum + 1;
            max = arr[(maximumNum + 1) % 6];
            min = arr[(maximumNum - 1 + 6) % 6];
        } else {
            maxNum = maximumNum - 1;
            max = arr[(maximumNum - 1 + 6) % 6];
            min = arr[(maximumNum + 1) % 6];
        }
        int minimum = Math.min(arr[(maxNum - 1 + 6) % 6], arr[(maxNum + 1) % 6]);
        System.out.println((max * maximum - (max - min) * (maximum - minimum)) * T);
    }
}
