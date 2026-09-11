package category.leetcode._2026.september;

public class September11th {

    public int totalNumbers(int[] digits) {
        int answer = 0;
        int[] count = new int[10];

        for (int digit : digits) {
            count[digit]++;
        }

        for (int hundreds = 1; hundreds < 10; hundreds++) {
            if (count[hundreds] == 0) {
                continue;
            }

            count[hundreds]--;

            for (int tens = 0; tens < 10; tens++) {
                if (count[tens] == 0) {
                    continue;
                }

                count[tens]--;

                for (int ones = 0; ones < 10; ones += 2) {
                    if (count[ones] > 0) {
                        answer++;
                    }
                }

                count[tens]++;
            }

            count[hundreds]++;
        }

        return answer;
    }
}
