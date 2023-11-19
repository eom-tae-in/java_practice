package category.leetcode.september;

public class September26th {

    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] asciiArr = new int[128];
        boolean[] used = new boolean[128];
        for (final char c : s.toCharArray()) {
            ++asciiArr[c];
        }
        for (final char c : s.toCharArray()) {
            --asciiArr[c];
            if (used[c]) {
                continue;
            }
            while (sb.length() > 0 && last(sb) > c && asciiArr[last(sb)] > 0) {
                used[last(sb)] = false;
                sb.setLength(sb.length() - 1);
            }
            used[c] = true;
            sb.append(c);
        }
        return sb.toString();
    }

    private char last(StringBuilder sb) {
        return sb.charAt(sb.length() - 1);
    }
}