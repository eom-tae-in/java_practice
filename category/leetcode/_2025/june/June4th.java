package category.leetcode._2025.june;

public class June4th {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        String sub = findLexicographicallyLargestString(word);
        int n = Math.min(sub.length(), word.length() - numFriends + 1);

        return sub.substring(0, n);
    }

    private String findLexicographicallyLargestString(String word) {
        int i = 0;
        int j = 1;
        int k = 0;
        int n = word.length();

        while (j + k < n) {
            if (word.charAt(i + k) == word.charAt(j + k)) {
                k++;
            } else if (word.charAt(i + k) > word.charAt(j + k)) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }
        }

        return word.substring(i);
    }
}
