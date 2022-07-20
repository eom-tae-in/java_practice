package Category;

import java.util.Scanner;

public class q_10950 {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        int arr[] = new int[a];

        for (int i = 0; i<a; i++){

            int x,y;

            x = sc.nextInt();
            y = sc.nextInt();

            arr[i] = x+y;

        }
        for (int j=0; j<a; j++){

            System.out.println(arr[j]);
        }

    }
}
