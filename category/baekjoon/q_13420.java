package category.baekjoon;

import java.util.Scanner;

public class q_13420 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        while(T-->0) {
            char[] c = sc.nextLine().replaceAll(" ", "").toCharArray();
            StringBuilder left = new StringBuilder();
            char mid;
            StringBuilder right = new StringBuilder();
            StringBuilder result = new StringBuilder();
            int k = 0;
            for(int i=0; true; i++) {
                if(i > 0 && (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/')) {
                    k = i+1;
                    mid = c[i];
                    break;
                } else left.append(c[i]);
            }
            for(int i=k; true; i++) {
                if(c[i] == '=') {
                    k = i+1;
                    break;
                } else right.append(c[i]);
            }
            for(int i=k; i<c.length; i++)
                result.append(c[i]);

            long ans = 0;
            if(mid == '+') ans = Long.parseLong(left.toString()) + Long.parseLong(right.toString());
            if(mid == '-') ans = Long.parseLong(left.toString()) - Long.parseLong(right.toString());
            if(mid == '*') ans = Long.parseLong(left.toString()) * Long.parseLong(right.toString());
            if(mid == '/') ans = Long.parseLong(left.toString()) / Long.parseLong(right.toString());

            System.out.println(ans == Long.parseLong(result.toString()) ? "correct" : "wrong answer");
        }
    }
}
