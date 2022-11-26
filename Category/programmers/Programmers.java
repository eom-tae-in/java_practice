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

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (divisor(i) % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static int divisor(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
                if (num != i * i) {
                    count++;
                }
            }
        }
        return count;
    }
}