package category.leetcode._2025.june;

public class June22nd {

    public String[] divideString(String s, int k, char fill) {
        int sLength = s.length();
        String[] answer = new String[(k - 1 + sLength) / k];
        int index = 0;

        for (int i = 0; i < answer.length - 1; i++) {
            String substring = s.substring(index, index + k);
            answer[i] = substring;
            index += k;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(index));

        if (stringBuilder.length() < k) {
            int len = k - stringBuilder.length();

            for (int i = 0; i < len; i++) {
                stringBuilder.append(fill);
            }
        }

        answer[answer.length - 1] = stringBuilder.toString();
        return answer;
    }
}
