package category.leetcode._2024.october;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class October11th {

    public int smallestChair(final int[][] times, final int targetFriend) {
        int chairNumber = 0;
        Queue<Integer> availableChairs = new PriorityQueue<>();
        Queue<FriendChair> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.leaveTime));
        List<FriendTime> friendTimes = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            int arriveTime = times[i][0];
            int leaveTime = times[i][1];
            friendTimes.add(new FriendTime(i, arriveTime, leaveTime));
        }

        friendTimes.sort(Comparator.comparingInt(FriendTime::arriveTime));

        for (FriendTime friendTime : friendTimes) {
            int currentIndex = friendTime.friendIndex;
            int currentArriveTime = friendTime.arriveTime;
            int currentLeaveTime = friendTime.leaveTime;

            while (!queue.isEmpty() && queue.peek().leaveTime <= currentArriveTime) {
                availableChairs.add(queue.poll().chairNumber);
            }

            if (currentIndex == targetFriend) {
                return availableChairs.isEmpty() ? chairNumber : availableChairs.poll();
            }

            if (availableChairs.isEmpty()) {
                queue.add(new FriendChair(currentLeaveTime, chairNumber++));
            } else {
                queue.add(new FriendChair(currentLeaveTime, availableChairs.poll()));
            }
        }

        throw new IllegalArgumentException();
    }

    private record FriendTime(
            int friendIndex,
            int arriveTime,
            int leaveTime
    ) {
    }

    private record FriendChair(
            int leaveTime,
            int chairNumber
    ) {
    }
}
