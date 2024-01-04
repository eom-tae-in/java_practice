package category.leetcode._2023.october;

public class October31st {

    public int[] findArray(int[] pref) {
        int[] answer = new int[pref.length];
        answer[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            answer[i] = pref[i] ^ pref[i - 1];
        }
        return answer;
    }
}
