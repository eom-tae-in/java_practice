package Category.baekjoon;

import java.util.Scanner;

public class q_1292 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] array = new int[1002];
        int count = 1;
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = 0;

        for (int i =1; i <= 1000; i++){

            for(int j = 0; j < i; j++){

                if(count == 1001){
                    break;
                }
                array[count] = i;
                count++;
            }
        }

        for(int i = a; i <= b; i++){

            sum += array[i];
        }

        System.out.println(sum);
    }
}


