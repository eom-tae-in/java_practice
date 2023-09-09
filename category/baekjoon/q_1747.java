package category.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class q_1747 {

    static int T;
    static ArrayList<Integer> primenumber = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        prime();

        System.out.println(minPalindrome(T));
    }

    public static void prime() {

        primenumber.add(2);
        primenumber.add(3);

        for (int i = 4; i <= 1005000; i++) {

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    break;
                }
                if (j == (int)Math.sqrt(i)) {

                    primenumber.add(i);
                }
            }
        }
    }

    public static String minPalindrome(int T) {
        int i = -1;

        String str = "";
        String A = String.valueOf(T);
        while (true){

            i++;

            if (i == primenumber.size()) {
                str = A + "은 조건에 맞는 소수 펠린드롬수가 없습니다.";
                break;
            }

            if (primenumber.get(i) < T) {
                continue;
            }
            str = String.valueOf(primenumber.get(i));

            StringBuilder fr = new StringBuilder();
            StringBuilder ba = new StringBuilder();


            for (int j = 0; j < str.length() / 2; j++) {
                fr.append(str.charAt(j));
                ba.append(str.charAt(str.length() - (j + 1)));
            }

            if (fr.toString().equals(ba.toString())) {
                break;
            }
        }
        return str;
    }
}
