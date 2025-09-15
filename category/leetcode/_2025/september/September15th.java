package category.leetcode._2025.september;

public class September15th {

    public int canBeTypedWords(String text, String brokenLetters) {
        int answer = 0;
        boolean[] isBroken = new boolean[26];

        for (int i = 0; i < brokenLetters.length(); i++) {
            isBroken[brokenLetters.charAt(i) - 'a'] = true;
        }

        for (String split : text.split(" ")) {
            if (!hasBroken(split, isBroken)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean hasBroken(String str, boolean[] isBroken) {
        for (int i = 0; i < str.length(); i++) {
            if (isBroken[str.charAt(i) - 'a']) {
                return true;
            }
        }

        return false;
    }
}
