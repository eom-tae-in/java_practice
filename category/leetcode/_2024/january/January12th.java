package category.leetcode._2024.january;

public class January12th {

    public boolean halvesAreAlike(final String s) {
        final int halfLength = s.length() / 2;
        String a = s.substring(0, halfLength);
        String b = s.substring(halfLength);
        final int aVowelCount = countVowel(a);
        final int bVowelCount = countVowel(b);

        return aVowelCount == bVowelCount;
    }
    private int countVowel(final String s) {
        return (int) s.chars()
                .filter(c -> isVowel((char) c))
                .count();
    }

    private boolean isVowel(final char character) {
        return "AEIOUaeiou".indexOf(character) != -1;
    }
}
