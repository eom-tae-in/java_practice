package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String my_stirng = sc.next();
            System.out.println(solution(my_stirng));
        }

        public static int solution(String my_string) {
            int answer = 0;
            String[] numbers = my_string.split("[a-zA-Z]");

            for (String number : numbers) {
                if (number.equals("")) {
                    continue;
                }
                answer += Integer.parseInt(number);
            }
            return answer;
        }
    }
}