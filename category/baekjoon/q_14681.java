package category.baekjoon;

import java.util.Scanner;

public class q_14681 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a,b;

        a = sc.nextInt();
        b= sc.nextInt();


        if (a > 0 && b> 0){

            System.out.println(1);
        }
        else if(a < 0 && b > 0){

            System.out.println(2);

        }
        else if(a < 0 && b < 0){

            System.out.println(3);

        }
        else if(a > 0 && b < 0){

            System.out.println(4);

        }
        else{
            System.out.println("a와 b 모두 0인 원점입니다.");

        }
    }
}
