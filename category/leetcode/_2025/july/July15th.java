package category.leetcode._2025.july;

public class July15th {

    public boolean isValid(String word) {
        int wordLength = word.length();

        if (wordLength < 3) {
            return false;
        }

        boolean hasConsonant = false;
        boolean hasVowel = false;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < wordLength; i++) {
            char current = word.charAt(i);

            if (isAlphabet(current)) {
                if (!hasVowel && vowels.indexOf(current) != -1) {
                    hasVowel = true;
                }

                if (!hasConsonant && vowels.indexOf(current) == -1) {
                    hasConsonant = true;
                }
            } else if (!Character.isDigit(current)) {
                return false;
            }
        }

        return hasConsonant && hasVowel;
    }

    private boolean isAlphabet(char current) {
        return ('a' <= current && current <= 'z') || ('A' <= current && current <= 'Z');
    }
}
