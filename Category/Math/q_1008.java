package Category.Math;

import java.util.Scanner;

public class q_1008 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double a, b;

        a = sc.nextDouble();
        b = sc.nextDouble();

        System.out.println(a/b);

    } //double형의 연산은 반복될 시 오차가 발생할 수 있지만 이 문제 같은 단순한 1회 연산에선 수소점 아래 9자리 이내 오차 위험이
      // 없으므로 그대로 출력한다.
}
