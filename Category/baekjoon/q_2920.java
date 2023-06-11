package Category.baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class q_2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[8];
        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        if (IntStream.range(0, input.length).allMatch(i -> input[i] == ascending[i])) {
            System.out.println("ascending");
            return;
        }
        if (IntStream.range(0, input.length).allMatch(i -> input[i] == descending[i])) {
            System.out.println("descending");
            return;
        }
        System.out.println("mixed");
    }
}
