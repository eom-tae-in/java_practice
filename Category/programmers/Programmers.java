package Category.programmers;

import java.util.Scanner;

public class Programmers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(solution.solution(a, b));

    }
    class solution{
        public static String solution(int a, int b) {
            int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            String[] day = {"THU", "FRI", "SAT ","SUN ", "MON","TUE","WED"};

            String answer = "";
            int sum = 0;

            for(int i = 0; i< a-1; i++){
                sum += monthDays[i];
            }
            sum += b;

            answer = day[sum % 7];
            return answer;
        }
    }


}