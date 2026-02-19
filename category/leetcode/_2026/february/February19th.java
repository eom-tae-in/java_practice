package category.leetcode._2026.february;

public class February19th {

    public int countBinarySubstrings(String s) {
        int sLength = s.length();
        int answer = 0;
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < sLength; i++) {
            char current = s.charAt(i);
            int index = i;

            while (i < sLength - 1 && s.charAt(i + 1) == current) {
                i++;
            }

            if (current == '0') {
                zeroCount = i + 1 - index;
            } else {
                oneCount = i + 1 - index;
            }

            if (zeroCount != 0 && oneCount != 0) {
                answer += Math.min(zeroCount, oneCount);
            }
        }

        return answer;
    }
}
