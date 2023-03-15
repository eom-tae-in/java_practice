package Category.baekjoon;

import java.util.*;

public class q_1141 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Map<String, Integer> input = new HashMap<>();
        for (int i = 0; i < num; i++) {
            String x = sc.next();
            input.put(x, input.getOrDefault(x, 0) + 1);
        }
        Map<Character, Integer> countPrefix = new HashMap<>();
        input.keySet().forEach(s -> countPrefix.put(s.charAt(0), countPrefix.getOrDefault(s.charAt(0), 0) + 1));

        int max = 0;
        char target = ' ';
        if (countPrefix.size() != 1) {
            for (Map.Entry<Character, Integer> entry : countPrefix.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    target = entry.getKey();
                }
            }
            answer += countPrefix.remove(target);
        }
        answer += input.values().stream()
                .filter(integer -> integer > 2).reduce(0, Integer::sum) + countPrefix.size();
        System.out.println(answer);
    }
}