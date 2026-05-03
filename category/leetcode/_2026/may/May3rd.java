package category.leetcode._2026.may;

public class May3rd {

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        s = s + s;

        return s.contains(goal);
    }
}
