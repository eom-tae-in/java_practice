package Category.programmers;

import java.util.*;

public class functionalDevelopment {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] progresses = new int[num];
        int[] speeds = new int[num];
        for (int i = 0; i < num; i++) {
            progresses[i] = sc.nextInt();
        }
        for (int i = 0; i < num; i++) {
            speeds[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        while (!queue.isEmpty()){
            int day = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && day >= queue.peek()){
                count++;
                queue.poll();
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}
