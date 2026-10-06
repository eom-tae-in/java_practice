package category.leetcode._2026.october;

public class October6th {

    public int minAddToMakeValid(String s) {
        int answer = 0;
        int status = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                status++;
            } else {
                status--;

                if (status < 0) {
                    answer++;
                    status = 0;
                }
            }
        }

        return answer + status;
    }
}
