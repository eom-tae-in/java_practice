package category.leetcode._2025.december;

public class December26th {

    public int bestClosingTime(String customers) {
        int answer = 0;
        int curr = 0;
        int idx = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                curr++;

                if (answer < curr) {
                    answer = curr;
                    idx = i + 1;
                }
            } else {
                curr--;
            }
        }

        return idx;
    }
}
