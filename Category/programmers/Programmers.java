package Category.programmers;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int index = sc.nextInt();
            int[] array = new int[index];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            int number = sc.nextInt();
            System.out.println(solution(array, number));
        }
    }

    public static int solution(int[] array, int n) {
        int answer = 0;
        for (int j : array) {
            if (j == n) {
                answer++;
            }
        }
        return answer;
    }
}