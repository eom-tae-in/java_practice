package Category;

import java.util.Arrays;
import java.util.Scanner;

public class q_2485 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] arr = new int[T];
        int[] D = new int[T-1];

        int count = 0;

        for (int i = 0; i < T; i++){

            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < T-1; i++){

            D[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(D);

        int distance = gcd(D[0], D[T-2]);

        for (int i = 0; i < T-2; i++){

            if (distance > gcd(D[i], D[i+1])){

                distance = gcd(D[i], D[i+1]);

            }
            if (distance == 1){
                break;
            }

        }
        for (int i = 0; i < T-1; i++){

            if (distance != D[i]){

                count += D[ i] / distance - 1 ;
            }
        }

        System.out.println(count);
    }

    static int gcd (int a, int b) {

        while (b > 0){

            int t = a;
            a = b;
            b = t % b;
        }
        return a;
    }
}
