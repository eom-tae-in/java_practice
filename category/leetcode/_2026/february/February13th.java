package category.leetcode._2026.february;

import java.util.HashMap;
import java.util.Map;

public class February13th {

    private static final int ENCODE_BASE = 100_000;

    public int longestBalanced(String s) {
        int answer = 0;
        answer = Math.max(answer, longestSingleChar(s));
        answer = Math.max(answer, longestTwoChar(s));
        answer = Math.max(answer, longestThreeChar(s));

        return answer;
    }

    private int longestSingleChar(String s) {
        int maxLen = 1;
        int cnt = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cnt++;
                maxLen = Math.max(maxLen, cnt);
            } else {
                cnt = 1;
            }
        }

        return maxLen;
    }

    private int longestTwoChar(String s) {
        int maxLen = 0;
        String[] strs = new String[]{"ab", "ac", "bc"};

        for (String str : strs) {
            maxLen = Math.max(maxLen, longestTwoCharPair(str.charAt(0), str.charAt(1), s));
        }

        return maxLen;
    }

    private int longestTwoCharPair(char x, char y, String s) {
        int n = s.length();
        int size = 2 * n + 1;
        int[] first = new int[size];
        int[] seen = new int[size];
        int version = 1;
        int sum = 0;
        int maxLen = 0;
        first[n] = -1;
        seen[n] = version;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == x) {
                sum++;
            } else if (c == y) {
                sum--;
            } else {
                version++;
                sum = 0;
                first[n] = i;
                seen[n] = version;
                continue;
            }

            int idx = sum + n;

            if (seen[idx] == version) {
                maxLen = Math.max(maxLen, i - first[idx]);
            } else {
                seen[idx] = version;
                first[idx] = i;
            }
        }

        return maxLen;
    }

    private int longestThreeChar(String s) {
        Map<Integer, Integer> firstIdx = new HashMap<>();
        firstIdx.put(encode(0, 0), -1);
        int a = 0;
        int b = 0;
        int c = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                a++;
            } else if (ch == 'b') {
                b++;
            } else {
                c++;
            }

            int key = encode(a - b, b - c);

            if (firstIdx.containsKey(key)) {
                maxLen = Math.max(maxLen, i - firstIdx.get(key));
            } else {
                firstIdx.put(key, i);
            }
        }

        return maxLen;
    }

    private int encode(int primary, int secondary) {
        return primary * ENCODE_BASE + secondary;
    }
}
