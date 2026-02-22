package category.leetcode._2026.february;

public class February22nd {

    public int binaryGap(int n) {
        String str = Integer.toBinaryString(n);
        int answer = 0;
        int prevOneIdx = 0;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                answer = Math.max(answer, i - prevOneIdx);
                prevOneIdx = i;
            }
        }

        return answer;
    }
}
