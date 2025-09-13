package category.leetcode._2025.september;

public class September13th {

    public int maxFreqSum(String s) {
        int vowelMax = 0;
        int consonantMax = 0;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            count[curr - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                vowelMax = Math.max(vowelMax, count[i]);
            } else {
                consonantMax = Math.max(consonantMax, count[i]);
            }
        }

        return vowelMax + consonantMax;
    }
}
