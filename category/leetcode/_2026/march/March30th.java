package category.leetcode._2026.march;

public class March30th {

    public boolean checkStrings(String s1, String s2) {
        int[] oddCount1 = new int[26];
        int[] evenCount1 = new int[26];
        int[] oddCount2 = new int[26];
        int[] evenCount2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 1) {
                oddCount1[s1.charAt(i) - 'a']++;
            } else {
                evenCount1[s1.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 1) {
                oddCount2[s2.charAt(i) - 'a']++;
            } else {
                evenCount2[s2.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if ((oddCount1[i] != oddCount2[i]) || (evenCount1[i] != evenCount2[i])) {
                return false;
            }
        }

        return true;
    }
}
