package category.leetcode._2025.june;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class June27th {

    public String longestSubsequenceRepeatedK(String s, int k) {
        String answer = "";
        int[] alphabetCounts = new int[26];

        for (char ch : s.toCharArray()) {
            alphabetCounts[ch - 'a']++;
        }

        List<Character> possibleAlphabets = new ArrayList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (alphabetCounts[ch - 'a'] >= k) {
                possibleAlphabets.add(ch);
            }
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.length() * k > s.length()) {
                return answer;
            }

            for (char possibleAlphabet : possibleAlphabets) {
                String sub = current + possibleAlphabet;
                if (isSubsequence(sub, s, k)) {
                    queue.offer(sub);
                    answer = sub;
                }
            }
        }

        return answer;
    }

    private boolean isSubsequence(String sub, String s, int k) {
        int index = 0;
        int sLength = s.length();
        int count = 0;

        for (int i = 0; i < sLength; i++) {
            if (sub.charAt(index) == s.charAt(i)) {
                if (++index == sub.length()) {
                    if (++count == k) {
                        return true;
                    }

                    index = 0;
                }
            }
        }

        return false;
    }
}
