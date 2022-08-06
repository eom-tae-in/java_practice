package Category;

import java.util.Scanner;
public class q_1929 {
    public static boolean[] prime;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int Z = in.nextInt();

        prime = new boolean[Z + 1];
        P();

        for(int i = A; i <= Z; i++) {
            if(!prime[i]) System.out.println(i);
        }
    }

    public static void P() {
        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}