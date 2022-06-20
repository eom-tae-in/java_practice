package Category.Math;

import java.util.Scanner;

public class q_2576 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = new int[7];

        int min = 100;
        int total = 0;

        for (int i = 0; i<7; i++){

            array[i] = sc.nextInt();

            if (array[i] % 2 == 1){

                total += array[i];

                if(min > array[i]){

                    min = array[i];
                }
            }
        }
        if(min == 100){

            min = -1;
            System.out.println(min);
        }

        if (min != -1){

            System.out.println(total);
            System.out.println(min);

        }
    }
}
