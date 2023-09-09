package category.programmers;

import java.util.*;

public class dislikeSameNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.add(arr[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
