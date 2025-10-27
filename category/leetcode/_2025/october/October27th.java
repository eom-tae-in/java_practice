package category.leetcode._2025.october;

public class October27th {

    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int answer = 0;
        int prevDevices = 0;

        for (int i = 0; i < m; i++) {
            if (bank[0].charAt(i) == '1') {
                prevDevices++;
            }
        }

        for (int i = 1; i < n; i++) {
            int currDevices = 0;

            for (int j = 0; j < m; j++) {
                if (bank[i].charAt(j) == '1') {
                    answer += prevDevices;
                    currDevices++;
                }
            }

            if (currDevices != 0) {
                prevDevices = currDevices;
            }
        }

        return answer;
    }
}
