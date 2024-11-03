package category.leetcode._2024.november;

public class November3rd {

    public boolean rotateString(final String s, final String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
