package category.leetcode.october;

public class October1st {

    public String reverseWords(String s) {
        char[] charArr = s.toCharArray();
        int point = 0;

        for (int i = 0; i < charArr.length; i++) {
            if (i == charArr.length - 1) {
                reverse(charArr, point, i);
            }
            if (charArr[i] == ' ') {
                reverse(charArr, point, i - 1);
                point = i + 1;
            }
        }
        return new String(charArr);
    }

    private void reverse(char[] charArr, int start, int end) {
        while (start < end) {
            char temp = charArr[start];
            charArr[start++] = charArr[end];
            charArr[end--] = temp;
        }
    }
}
