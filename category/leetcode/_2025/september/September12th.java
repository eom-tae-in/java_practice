package category.leetcode._2025.september;

public class September12th {

    public boolean doesAliceWin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return true;
            }
        }

        return false;
    }
}
