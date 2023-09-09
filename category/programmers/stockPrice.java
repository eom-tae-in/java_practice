package category.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class stockPrice {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] prices = new int[num];
        for (int i = 0; i < num; i++) {
            prices[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int num = 0;
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }
        while (!queue.isEmpty()) {
            int count = queue.remove();
            int n = 0;
            for (int i : queue) {
                n++;
                if (count > i) {
                    answer[num] = n;
                    break;
                }
            }
            if (n == queue.size()) {
                answer[num] = queue.size();
            }
            num++;
        }
        return answer;
    }
}
