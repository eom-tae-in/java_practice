package category.leetcode._2025.october;

public class October20th {

    public int finalValueAfterOperations(String[] operations) {
        int answer = 0;

        for (String operation : operations) {
            if (operation.charAt(1) == '+') {
                answer++;
            } else {
                answer--;
            }
        }

        return answer;
    }
}
