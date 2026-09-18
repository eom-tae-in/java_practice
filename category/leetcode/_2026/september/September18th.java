package category.leetcode._2026.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class September18th {

    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);

        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] == -1) {
                first[ch] = i;
            }

            last[ch] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int ch = 0; ch < 26; ch++) {
            if (first[ch] == -1) {
                continue;
            }

            int start = first[ch];
            int end = findEnd(s, start, first, last);

            if (end != -1) {
                intervals.add(new int[]{start, end});
            }
        }

        intervals.sort(Comparator.comparingInt(interval -> interval[1]));
        List<String> answer = new ArrayList<>();
        int previousEnd = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > previousEnd) {
                answer.add(s.substring(start, end + 1));
                previousEnd = end;
            }
        }

        return answer;
    }

    private int findEnd(String s, int start, int[] first, int[] last) {
        int end = last[s.charAt(start) - 'a'];

        for (int i = start; i <= end; i++) {
            int ch = s.charAt(i) - 'a';

            if (first[ch] < start) {
                return -1;
            }

            end = Math.max(end, last[ch]);
        }

        return end;
    }
}
