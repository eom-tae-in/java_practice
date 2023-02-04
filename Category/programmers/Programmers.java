package Category.programmers;

import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String t = sc.next();
            String p = sc.next();
            System.out.println(solution(t, p));
        }

        public static int solution(String t, String p) {
            int answer = 0;
            long pNumber = Long.parseLong(p);
            int tryCount = t.length() - p.length();

            for (int i = 0; i <= tryCount; i++) {
                long tNumber = Long.parseLong(t.substring(i, i+ p.length()));
                if (tNumber <= pNumber) {
                    answer++;
                }
            }
            return answer;
        }
    }
}