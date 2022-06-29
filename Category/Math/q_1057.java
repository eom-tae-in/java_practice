package Category.Math;


import java.util.Scanner;

public class q_1057 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int count = 0;

        if(Math.abs(x-y) == 1 && (Math.max(x,y) % 2 == 0)){

            count++;
        }
        else{

            for(count = 1; ((Math.abs(x-y) != 1) || (Math.max(x,y) % 2) != 0);){

                x = (int)Math.ceil(x/2.0);
                y = (int)Math.ceil(y/2.0);

                count++;
            }

        }

        System.out.println(count);
    }
}
