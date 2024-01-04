package category.leetcode._2023.december;

public class December2nd {

    public int countCharacters(final String[] words, final String chars) {
        int answer = 0;
        int[] count = new int[26];

        for (final char c : chars.toCharArray()) {
            count[c - 'a']++;
        }

        for (final String word : words) {
            int[] tempCount = count.clone();
            for (final char c : word.toCharArray()) {
                if (--tempCount[c - 'a'] < 0) {
                    answer -= word.length();
                    break;
                }
            }
            answer += word.length();
        }

        return answer;
    }
}
