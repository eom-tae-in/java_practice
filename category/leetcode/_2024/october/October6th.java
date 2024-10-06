package category.leetcode._2024.october;

public class October6th {

    public boolean areSentencesSimilar(final String sentence1, final String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }

        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        int m = words1.length;
        int n = words2.length;
        if (m > n) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int index = 0;
        while (index < m && words1[index].equals(words2[index])) {
            index++;
        }
        while (index < m && words1[index].equals(words2[index + n - m])) {
            index++;
        }

        return index == m;
    }
}
