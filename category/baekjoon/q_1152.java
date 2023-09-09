package category.baekjoon;

import java.util.Scanner;

public class q_1152 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        if (str.length() == 0) {
            System.out.println(0);
            return;
        }
        String[] strings = str.split(" ");
        System.out.println(strings.length);
    }
}
