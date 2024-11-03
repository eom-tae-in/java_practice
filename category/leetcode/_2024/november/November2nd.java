package category.leetcode._2024.november;

public class November2nd {

    public boolean isCircularSentence(final String sentence) {
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }

        String[] splitSentence = sentence.split(" ");
        char prev = splitSentence[0].charAt(splitSentence[0].length() - 1);

        for (int i = 1; i < splitSentence.length; i++) {
            if (prev != splitSentence[i].charAt(0)) {
                return false;
            }
            prev = splitSentence[i].charAt(splitSentence[i].length() - 1);
        }

        return true;
    }
}
