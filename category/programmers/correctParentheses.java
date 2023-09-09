package category.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class correctParentheses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                queue.add(c);
            }
            else if (c == ')') {
                if (queue.isEmpty()) {
                    return false;
                }
                queue.remove();
            }
        }
        return queue.isEmpty();
    }
}
