package category.leetcode._2025.september;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class September11th {

    public String sortVowels(String s) {
        List<Character> vowels = new ArrayList<>();
        char[] sChars = s.toCharArray();

        for (char ch : sChars) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        int index = 0;
        Collections.sort(vowels);

        for (int i = 0; i < sChars.length; i++) {
            if (isVowel(sChars[i])) {
                sChars[i] = vowels.get(index++);
            }
        }

        return new String(sChars);
    }

    private boolean isVowel(char ch) {
        for (char vowel : new char[]{'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}) {
            if (ch == vowel) {
                return true;
            }
        }

        return false;
    }
}
