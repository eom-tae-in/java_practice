package Category.baekjoon;

import java.util.Scanner;
import java.util.HashSet;

public class q_3052 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashSet<Integer> Hash = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            Hash.add(sc.nextInt() % 42);
            }

        sc.close();
        System.out.print(Hash.size());
    }
}

