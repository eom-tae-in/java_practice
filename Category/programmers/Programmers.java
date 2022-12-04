package Category.programmers;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            System.out.println(solution(num1, num2));
        }
    }

    public static int solution(int num1, int num2) {
        int answer = 0;
        double num = (double) num1 / (double) num2;
        num *= 1000;
        answer = (int) num;
        return answer;
    }
}