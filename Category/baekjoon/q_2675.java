package Category.baekjoon;

import java.util.Scanner;

public class q_2675 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int count = sc.nextInt();
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                sb.append(String.valueOf(str.charAt(j)).repeat(count));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
