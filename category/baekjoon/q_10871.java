package category.baekjoon;

import java.util.Scanner;

public class q_10871 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int arr[] = new int[a];

        for (int j=0; j<a; j++){

            arr[j] = sc.nextInt();
        }

        for (int i = 0; i<a; i++){

            if(arr[i] < b){

                System.out.println(arr[i]);
            }
        }
    }
}
