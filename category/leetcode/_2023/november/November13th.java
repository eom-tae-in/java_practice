package category.leetcode._2023.november;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class November13th {

    public String sortVowels(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> vowels = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
        }

        Collections.sort(vowels);
        int index = 0;

        for (char ch : s.toCharArray()) {
            sb.append(isVowel(ch) ? vowels.get(index++) : ch);
        }

        return sb.toString();
    }

    private boolean isVowel(final char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
