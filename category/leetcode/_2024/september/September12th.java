package category.leetcode._2024.september;

public class September12th {

    public int countConsistentStrings(final String allowed, final String[] words) {
        int answer = 0;
        boolean[] alphabets = new boolean[26];
        for (char ch : allowed.toCharArray()) {
            alphabets[ch - 'a'] = true;
        }
        for (String word : words) {
            boolean isConsistent = true;
            for (char ch : word.toCharArray()) {
                if (!alphabets[ch - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                answer++;
            }
        }

        return answer;
    }
}
