package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = sc.next();
            }
            System.out.println(solution(strings));
        }
        public static String solution(String[] seoul) {
            String answer = "";
            for (int i = 0; i < seoul.length; i++) {
                if (seoul[i].equals("Kim")) {
                    answer += "김서방은 " + i + "에 있다";
                    break;
                }
            }
            return answer;
        }
    }
}