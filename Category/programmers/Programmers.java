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
        int answer = num1 % num2;
        return answer;
    }
}