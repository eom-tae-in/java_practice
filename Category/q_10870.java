package Category;

import java.util.Scanner;

public class q_10870 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(F(n));
    }


    static int F(int n) {
        if (n == 0)	return 0;
        if (n == 1)	return 1;
        return F(n - 1) + F(n - 2);
    }
}


