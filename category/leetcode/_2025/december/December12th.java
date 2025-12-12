package category.leetcode._2025.december;

import java.util.Comparator;
import java.util.List;

public class December12th {

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        User[] users = new User[numberOfUsers];

        for (int i = 0; i < numberOfUsers; i++) {
            users[i] = new User();
        }

        events.sort(Comparator.comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
                .thenComparing((List<String> e) -> e.get(0), Comparator.reverseOrder()));

        for (List<String> event : events) {
            System.out.println(event.toString());
            String type = event.get(0);
            int time = Integer.parseInt(event.get(1));

            if (type.equals("MESSAGE")) {
                String[] targets = event.get(2).split(" ");

                if (targets[0].equals("ALL")) {
                    applyAllEvents(users);
                } else if (targets[0].equals("HERE")) {
                    applyHereEvents(users, time);
                } else {
                    applyTargetsEvents(users, targets);
                }
            } else {
                applyOfflineEvents(users, time, event.get(2));
            }
        }

        int[] answer = new int[numberOfUsers];

        for (int i = 0; i < numberOfUsers; i++) {
            answer[i] = users[i].count;
        }

        return answer;
    }

    private void applyOfflineEvents(User[] users, int time, String target) {
        int id = Integer.parseInt(target);
        users[id].applyOffline(time);
    }

    private void applyAllEvents(User[] users) {
        for (User user : users) {
            user.count++;
        }
    }

    private void applyHereEvents(User[] users, int time) {
        for (User user : users) {
            if (user.isOnline(time)) {
                user.count++;
            }
        }
    }

    private void applyTargetsEvents(User[] users, String[] targets) {
        for (String target : targets) {
            int id = Integer.parseInt(target.substring(2));
            users[id].count++;
        }
    }


    private static class User {

        private int offLineTimestamp;
        private int count;

        private User() {
            offLineTimestamp = 0;
            count = 0;
        }

        private boolean isOnline(int timestamp) {
            return timestamp >= offLineTimestamp;
        }

        private void applyOffline(int timestamp) {
            offLineTimestamp = timestamp + 60;
        }
    }
}
