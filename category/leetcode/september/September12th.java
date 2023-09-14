package category.leetcode.september;

import java.util.HashSet;
import java.util.Set;

public class September12th {

    public int minDeletions(String s) {
        int[] alphabetCount = new int[26];
        int answer = 0;
        for (char c : s.toCharArray()) {
            alphabetCount[c - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        for (int count : alphabetCount) {
            while (set.contains(count) && count > 0) {
                answer++;
                count--;
            }
            set.add(count);
        }
        return answer;
    }
}
