package category.leetcode._2025.june;

public class June10th {

    public int maxDifference(String s) {
        int oddMax = Integer.MIN_VALUE;
        int evenMin = Integer.MAX_VALUE;
        int[] alphabets = new int[26];
        int sLength = s.length();

        for (int i = 0; i < sLength; i++) {
            alphabets[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            int current = alphabets[i];

            if (current % 2 == 0) {
                if (0 < current && current < evenMin) {
                    evenMin = current;
                }
            } else {
                if (current > oddMax) {
                    oddMax = current;
                }
            }
        }

        return oddMax - evenMin;
    }
}
