package category.leetcode._2025.july;

public class July1st {

    public int possibleStringCount(String word) {
        int answer = 1;
        char prev = '@';

        for (char ch : word.toCharArray()) {
            if (prev == ch) {
                answer++;
            } else {
                prev = ch;
            }
        }

        return answer;
    }
}
