package category.leetcode._2026.september;

public class September20th {

    public int reverseDegree(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            answer += ('z' - curr + 1) * (i + 1);
        }

        return answer;
    }
}
