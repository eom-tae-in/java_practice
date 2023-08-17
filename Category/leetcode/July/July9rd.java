package Category.leetcode.July;

import java.util.Arrays;
import java.util.Scanner;

public class July9rd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int max = 0;
        int[][] absoluteCount = new int[26][26];
        int[][] relativeCount = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(relativeCount[i], -s.length());
        }

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                absoluteCount[ch][j]++;
                relativeCount[ch][j]++;
                relativeCount[j][ch] = --absoluteCount[j][ch];
                absoluteCount[j][ch] = Math.max(absoluteCount[j][ch], 0);
                max = Math.max(max, Math.max(relativeCount[ch][j], relativeCount[j][ch]));
            }
        }
        return max;
    }
}
