package category.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class printer {

    static class Element {
        int num;
        int priority;
        public Element(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] priorities = new int[num];
        for (int i = 0; i < num; i++) {
            priorities[i] = sc.nextInt();
        }
        int location = sc.nextInt();
        System.out.println(solution(priorities, location));
    }

    public static int solution(int[] priorities, int location) {
        int count, answer = 0;
        Queue<Element> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Element(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
            Element element = queue.remove();
            count = 0;

            for (Element e : queue) {
                if (element.priority < e.priority) {
                    queue.add(element);
                    break;
                }
                count++;
            }
            if (count == queue.size()) {
                answer++;
                if (element.num == location) {
                    return answer;
                }
            }
        }
        return -1;
    }
}
