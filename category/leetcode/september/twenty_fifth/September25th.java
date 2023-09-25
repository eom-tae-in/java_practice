package category.leetcode.september.twenty_fifth;

public class September25th {

    public static char findTheDifference(String s, String t) {
        char answer = 0;
        for (char c : s.toCharArray()) {
            answer ^= c;
        }
        for (char c : t.toCharArray()) {
            answer ^= c;
        }
        return answer;
    }
}
