package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String bin1 = sc.next();
            String bin2 = sc.next();
            System.out.println(solution(bin1, bin2));
        }
        public static String solution(String bin1, String bin2) {
            return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
        }
    }
}