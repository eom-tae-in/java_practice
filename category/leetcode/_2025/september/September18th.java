package category.leetcode._2025.september;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class September18th {

    private static class TaskManager {

        private final Queue<Task> queue;
        private final Map<Integer, Task> taskMap;

        public TaskManager(List<List<Integer>> tasks) {
            queue = new PriorityQueue<>(
                    Comparator.comparingInt((Task t) -> t.priority)
                            .thenComparingInt((Task t) -> t.taskId)
                            .reversed()
            );
            taskMap = new HashMap<>();

            for (List<Integer> t : tasks) {
                Task task = new Task(t.get(0), t.get(1), t.get(2));
                queue.offer(task);
                taskMap.put(t.get(1), task);
            }
        }

        public void add(int userId, int taskId, int priority) {
            Task task = new Task(userId, taskId, priority);
            queue.offer(task);
            taskMap.put(taskId, task);
        }

        public void edit(int taskId, int newPriority) {
            Task task = taskMap.get(taskId);
            Task newTask = new Task(task.userId, task.taskId, newPriority);
            taskMap.put(taskId, newTask);
            queue.offer(newTask);
        }

        public void rmv(int taskId) {
            taskMap.remove(taskId);
        }

        public int execTop() {
            int userId = -1;

            while (!queue.isEmpty()) {
                Task poll = queue.poll();
                Task task = taskMap.get(poll.taskId);

                if (task != null && poll.priority == task.priority && poll.userId == task.userId) {
                    userId = poll.userId;
                    taskMap.remove(task.taskId);
                    break;
                }
            }

            return userId;
        }

        private record Task(int userId, int taskId, int priority) {
        }
    }
}
