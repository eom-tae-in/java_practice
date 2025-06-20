package category.leetcode._2025.june;

public class June20th {

    public int maxDistance(String s, int k) {
        int answer = 0;
        int east = 0;
        int west = 0;
        int south = 0;
        int north = 0;
        char[] sCharArray = s.toCharArray();

        for (int i = 0; i < sCharArray.length; i++) {
            char ch = sCharArray[i];

            if (ch == 'E') {
                east++;
            } else if (ch == 'W') {
                west++;
            } else if (ch == 'S') {
                south++;
            } else {
                north++;
            }

            int current = Math.abs(east - west) + Math.abs(south - north);
            answer = Math.max(answer, current + Math.min(2 * k, i + 1 - current));
        }

        return answer;
    }
}
