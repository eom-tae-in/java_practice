package category.leetcode._2023.december;

public class December1st {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String word : word1) {
            stringBuilder.append(word);
        }

        String totalWord1 = stringBuilder.toString();
        stringBuilder.setLength(0);

        for (String word : word2) {
            stringBuilder.append(word);
        }

        String totalWord2 = stringBuilder.toString();
        return totalWord1.equals(totalWord2);
    }
}
