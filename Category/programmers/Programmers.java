package Category.programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

public class Programmers {

    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String my_string = br.readLine();
            System.out.println(solution(my_string));
        }

        public static String solution(String my_string) {
            return deduplicate(my_string);
        }

        public static String deduplicate(String my_string) {
            LinkedHashSet<String> deduplication = new LinkedHashSet<>();
            for (int i = 0; i < my_string.length(); i++) {
                deduplication.add(String.valueOf(my_string.charAt(i)));
            }
            String[] deduplicatedArray = new String[deduplication.size()];
            deduplicatedArray = deduplication.toArray(deduplicatedArray);
            return String.join("", deduplicatedArray);
        }

    }
}