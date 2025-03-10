package category.leetcode._2025.march;

import java.util.Arrays;

public class March10th {

    public long countOfSubstrings(final String word, final int k) {
        long answer = 0;
        String vowel = "aeiou";
        int[] charsCount = new int[6];
        int[] currentCharsCount = new int[6];
        int middlePointer = 0;
        int wordLength = word.length();
        int distinctVowelCount = 0;

        for (int leftPointer = 0, rightPointer = 0; rightPointer < wordLength; rightPointer++) {
            int charsCountIndex = vowel.indexOf(word.charAt(rightPointer)) + 1;

            if (++charsCount[charsCountIndex] == 1 && charsCountIndex > 0) {
                distinctVowelCount++;
            }

            while (charsCount[0] > k) {
                int leftMostCharsCountIndex = vowel.indexOf(word.charAt(leftPointer++)) + 1;

                if (--charsCount[leftMostCharsCountIndex] == 0 && leftMostCharsCountIndex > 0) {
                    distinctVowelCount--;
                }
            }

            if (distinctVowelCount == 5 && charsCount[0] == k) {
                if (middlePointer < leftPointer) {
                    middlePointer = leftPointer;
                    Arrays.fill(currentCharsCount, 0);
                }

                int leftMostCharsCountIndex = vowel.indexOf(word.charAt(middlePointer)) + 1;

                while (leftMostCharsCountIndex != 0 &&
                        charsCount[leftMostCharsCountIndex] - currentCharsCount[leftMostCharsCountIndex] > 1) {
                    currentCharsCount[leftMostCharsCountIndex]++;
                    leftMostCharsCountIndex = vowel.indexOf(word.charAt(++middlePointer)) + 1;
                }

                answer += middlePointer - leftPointer + 1;
            }
        }

        return answer;
    }
}
