package Category.programmers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Programmers {

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            System.out.println(solution(s));
        }

        public static String solution(String s) {
            String answer = "";
            List<String> list = new ArrayList<>();
            Set<String> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(String.valueOf(s.charAt(i)));
                System.out.println(set);
            }
            for (int i = 0; i < s.length(); i++) {
                if (list.contains(String.valueOf(s.charAt(i)))) {
                    set.remove(String.valueOf(s.charAt(i)));
                    continue;
                }
                list.add(String.valueOf(s.charAt(i)));
            }
            System.out.println(set);
            String[] str = set.toArray(new String[0]);
            Arrays.sort(str);
            answer = String.join("", str);
            return answer;
        }
    }
}