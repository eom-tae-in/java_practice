package Category.programmers;

import java.util.Scanner;

public class targetNumber {
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] numbers = new int[num];
        for (int i = 0; i < num; i++) {
            numbers[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(solution(numbers, target));
    }
    public static int solution(int[] numbers, int target) {
        dfs(0,0, numbers, target);
        return answer;
    }

    public static void dfs(int L, int sum, int[] numbers, int target) {
        if (L == numbers.length) {
            if (target == sum) {
                answer++;
            }
        }
        else {
            dfs(L + 1, sum + numbers[L], numbers, target);
            dfs(L + 1, sum - numbers[L], numbers, target);
        }
    }
}
