package category.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q_1076 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] strs = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};

        String[] input = new String[3];

        for (int i = 0; i < 3; i++) {
            input[i] = sc.next();
        }

        String str = "";

        for (int j = 0; j < 2; j++) {

            for (int i = 0; i < strs.length; i++) {
                if (input[j].equals(strs[i])) {
                    str += i;
                    break;
                }
            }
        }
        int m = Arrays.asList(strs).indexOf(input[2]);

        long price = Integer.parseInt(str) * (long)Math.pow(10, m);

        System.out.println(price);
    }
}
