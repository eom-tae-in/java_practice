package Category.Math;
import java.util.Scanner;

public class q_1978 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        for(int i = 0; i < n; i++) {


            boolean prime = true;

            int num = sc.nextInt();

            if(num == 1) {
                continue;
            }
            for(int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime) {
                count++;
            }
        }
        System.out.println(count);
    }

}