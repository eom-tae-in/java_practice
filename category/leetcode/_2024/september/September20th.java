package category.leetcode._2024.september;

public class September20th {

    public String shortestPalindrome(final String str) {
        String reverseStr = new StringBuilder(str).reverse().toString();
        for (int i = 0; i < reverseStr.length(); ++i) {
            if (str.startsWith(reverseStr.substring(i))) {
                return reverseStr.substring(0, i) + str;
            }
        }

        return reverseStr + str;
    }
}
