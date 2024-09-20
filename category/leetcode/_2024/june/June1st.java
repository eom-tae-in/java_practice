package category.leetcode._2024.june;

public class June1st {

    public int scoreOfString(final String s) {
        int answer = 0;
        char[] sCharArray = s.toCharArray();
        for (int i = 0; i < sCharArray.length - 1; i++) {
            answer += Math.abs(sCharArray[i] - sCharArray[i + 1]);
        }

        return answer;
    }
}
