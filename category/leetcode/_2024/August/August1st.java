package category.leetcode._2024.August;

public class August1st {

    public int countSeniors(final String[] details) {
        int count = 0;
        for (String detail : details) {
            if (Integer.parseInt(detail.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }
}
