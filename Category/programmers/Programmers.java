package Category.programmers;

import java.util.Arrays;
import java.util.Scanner;

public class Programmers {

    static class Solution {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int s1Index = sc.nextInt();
            int s2Index = sc.nextInt();
            String[] s1 = new String[s1Index];
            String[] s2 = new String[s2Index];
            for (int i = 0; i < s1.length; i++) {
                s1[i] = sc.next();
            }
            for (int i = 0; i < s2.length; i++) {
                s2[i] = sc.next();
            }
            System.out.println(solution(s1, s2));
        }
    }

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String value : s1) {
            for (String s : s2) {
                if (s.equals(value)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}