package category.leetcode._2024.april;

public class April1st {

    public int lengthOfLastWord(final String s) {
        String[] stringArray = s.split(" ");

        return stringArray[stringArray.length - 1].length();
    }
}
