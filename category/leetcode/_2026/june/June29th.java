package category.leetcode._2026.june;

public class June29th {

    public int numOfStrings(String[] patterns, String word) {
        int answer = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                answer++;
            }
        }

        return answer;
    }
}
