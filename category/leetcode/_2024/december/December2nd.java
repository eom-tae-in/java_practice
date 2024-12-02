package category.leetcode._2024.december;

public class December2nd {

    public int isPrefixOfWord(final String sentence, final String searchWord) {
        String[] splitSentences = sentence.split(" ");
        int answer = -1;
        int index = 1;

        for (String splitSentence : splitSentences) {
            if (splitSentence.startsWith(searchWord)) {
                answer = answer == -1 ? index : answer;
            }

            index++;
        }

        return answer;
    }
}
