package category.leetcode._2023.july;

import java.util.Scanner;

public class July5th {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        int num = array.length;
        int left = 0;
        int answer = 0;
        int zeroCount = 0;
        for (int right = 0; right < num; right++) {
            if (array[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (array[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            answer = Math.max(answer, right - left);
        }
        return answer;
    }
}
