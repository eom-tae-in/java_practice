package category.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class q_10809 {

    static int[] alphabet;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        alphabet = new int[26];
        Arrays.fill(alphabet, -1);
        for (int i = 0; i < str.length(); i++) {
            if (alphabet[str.charAt(i) - 'a'] == -1) {
                alphabet[str.charAt(i) - 'a'] = i;
            }
        }
        for (int i : alphabet) {
            System.out.print(i + " ");
        }
    }
}
