package Category.baekjoon;

import java.util.Scanner;

public class q_1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int[] arr = new int[26];

        for (int i = 0; i < str.length(); i++) {

            arr[(str.charAt(i) - 65) % 32]++;
        }

        int max = 0;
        int maxnum = 0;
        int second = 0;
        for (int i = 0; i < 26; i++) {

            if (max <= arr[i]) {

                second = max;
                max = arr[i];
                maxnum = i;
            }
        }

        if (second == max) {
            System.out.println("?");
        } else {
            int c = maxnum + 65;
            System.out.println((char) c);
        }



    }

}
