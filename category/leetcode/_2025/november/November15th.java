package category.leetcode._2025.november;

public class November15th {

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int answer = 0;

        for (int zeroCount = 0; zeroCount + zeroCount * zeroCount <= n; zeroCount++) {
            int[] counts = new int[2];
            int lastInvalidPos = -1;

            for (int left = 0, right = 0; right < n; right++) {
                counts[s.charAt(right) - '0']++;

                while (left < right) {
                    int leftNum = s.charAt(left) - '0';

                    if (leftNum == 0 && counts[leftNum] > zeroCount) {
                        counts[leftNum]--;
                        lastInvalidPos = left;
                    } else if (leftNum == 1 && counts[leftNum] > zeroCount * zeroCount) {
                        counts[leftNum]--;
                    } else {
                        break;
                    }

                    left++;
                }

                if (counts[0] == zeroCount && counts[1] >= zeroCount * zeroCount) {
                    answer += left - lastInvalidPos;
                }
            }
        }

        return answer;
    }
}
