package category.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class travelRoute {
    static ArrayList<String> list;
    static boolean[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[][] tickets = new String[num][2];
        for (int i = 0; i < num; i++) {
            tickets[i][0] = sc.next();
            tickets[i][1] = sc.next();
        }
        System.out.println(Arrays.toString(solution(tickets)));
    }

    public static String[] solution(String[][] tickets) {
        int count = 0;
        list = new ArrayList<>();
        ch = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, count);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public static void dfs(String start, String route, String[][] tickets, int count) {
        if (count == tickets.length) {
            list.add(route);
        }
        for (int i = 0; i < tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !ch[i]) {
                ch[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, count + 1);
                ch[i] = false;
            }
        }
    }
}
