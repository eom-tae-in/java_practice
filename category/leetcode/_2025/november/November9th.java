package category.leetcode._2025.november;

public class November9th {

    public int countOperations(int num1, int num2) {
        int answer = 0;
        int primary = num1;
        int secondary = num2;

        while (primary != 0 && secondary != 0) {
            if (primary >= secondary) {
                primary -= secondary;
            } else {
                secondary -= primary;
            }

            answer++;
        }

        return answer;
    }
}
