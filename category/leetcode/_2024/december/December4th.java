package category.leetcode._2024.december;

public class December4th {

    public boolean canMakeSubsequence(final String str1, final String str2) {
        int str2Length = str2.length();
        int str2Index = 0;

        for (char ch : str1.toCharArray()) {
            char current = str2.charAt(str2Index);

            if (ch == current || 'a' + ((ch - 'a' + 1) % 26) == current) {
                if (++str2Index == str2Length) {
                    return true;
                }
            }
        }

        return false;
    }
}
