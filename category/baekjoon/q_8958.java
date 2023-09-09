package category.baekjoon;

import java.util.Scanner;

public class q_8958 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int score = 1;
            int sum = 0;
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'O') {
                    sum += score;
                    score++;
                    continue;
                }
                score = 1;
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}
