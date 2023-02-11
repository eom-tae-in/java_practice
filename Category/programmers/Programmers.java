package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String before = sc.next();
            String after = sc.next();
            System.out.println(solution(before, after));
        }

        public static int solution(String before, String after) {
            String sortedBefore = sortMethod(before);
            String sortedAfter = sortMethod(after);
            if (equalsValidation(sortedBefore, sortedAfter)) {
                return 1;
            }
            return 0;
        }

        public static String sortMethod(String str) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return new String(charArray);
        }

        public static boolean equalsValidation(String sortedBefore, String sortedAfter) {
            return sortedAfter.equals(sortedBefore);
        }
    }
}