package category.leetcode._2025.september;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class September17th {

    private static class FoodRatings {

        private final Map<String, Food> foodMap;
        private final Map<String, PriorityQueue<Food>> cuisineMap;

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            foodMap = new HashMap<>();
            cuisineMap = new HashMap<>();
            Comparator<Food> foodComparator = Comparator.comparingInt((Food f) -> f.rating)
                    .reversed()
                    .thenComparing((Food f) -> f.name);

            for (int i = 0; i < foods.length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], food);
                cuisineMap.computeIfAbsent(cuisines[i], key -> new PriorityQueue<>(foodComparator)).offer(food);
            }
        }

        public void changeRating(String foodName, int newRating) {
            Food food = foodMap.get(foodName);
            Food newFood = new Food(food.name, food.cuisine, newRating);
            foodMap.put(foodName, newFood);
            cuisineMap.get(food.cuisine).add(newFood);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> priorityQueue = cuisineMap.get(cuisine);

            while (!priorityQueue.isEmpty()) {
                Food top = priorityQueue.peek();
                Food current = foodMap.get(top.name);

                if (top.rating == current.rating) {
                    return top.name;
                } else {
                    priorityQueue.poll();
                }
            }

            return null;
        }

        private record Food(String name, String cuisine, int rating) {
        }
    }
}
