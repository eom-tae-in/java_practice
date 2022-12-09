package Category.programmers;
import java.util.Arrays;
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

    public static int solution(int[] array, int height) {
        int answer = 0;
        int num = 0;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] > height) {
                num = i;
                break;
            }
            if (i == array.length - 1) {
                num = array.length;
            }
        }
        answer = array.length - num;
        return answer;
    }
}