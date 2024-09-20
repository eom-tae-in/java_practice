package category.leetcode._2024.june;

public class June3rd {

    public int appendCharacters(final String s, final String t) {
        int sIndex = 0;
        int tIndex = 0;
        int sLength = s.length();
        int tLength = t.length();

        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }
            sIndex++;
        }

        return tLength - tIndex;
    }
}
