package Category.Math;

import java.util.Scanner;

public class q_1924 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        int sum = 0;


        for(int i = 1; i < x; i++){

            sum += days[i-1];
        }

        sum += y;

        if (sum % 7  == 0){
            System.out.println("SUN");
        }

        if (sum % 7  == 1){
            System.out.println("MON");
        }

        if(sum % 7  == 2){
            System.out.println("TUE");
        }

        if(sum % 7  == 3){
            System.out.println("WED");
        }

        if(sum % 7  == 4){
            System.out.println("THU");
        }

        if(sum % 7  == 5){
            System.out.println("FRI");
        }

        if(sum % 7  == 6){
            System.out.println("SAT");
        }

    }
}
