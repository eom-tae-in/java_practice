package Category.programmers;

import java.util.*;

public class passingBridgeTruck {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        int num = sc.nextInt();
        int[] truck_weights = new int[num];
        for (int i = 0; i < num; i++) {
            truck_weights[i] = sc.nextInt();
        }
        System.out.println(solution(bridge_length, weight, truck_weights));
    }

    public static int solution(int bridge_length, int weight, int[] truck_weight) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0, count = 0;
        for (int truck : truck_weight) {
            while (true) {
                if (queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    count++;
                    break;
                } else if (queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else {
                    if (sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        count++;
                        break;
                    } else {
                        queue.add(0);
                        count++;
                    }
                }
            }

        }
        return count + bridge_length;
    }
}