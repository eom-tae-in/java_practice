package category.leetcode._2025.september;

import java.util.*;

public class September21st {

    private static class MovieRentingSystem {

        private static final Comparator<Item> UNRENTED_COMPARATOR = Comparator.comparingInt(Item::price)
                .thenComparingInt(Item::shopId);

        private static final Comparator<Item> RENTED_COMPARATOR = Comparator.comparingInt(Item::price)
                .thenComparingInt(Item::shopId)
                .thenComparingInt(Item::movieId);

        private final TreeSet<Item> rentedMovies;
        private final Map<Integer, TreeSet<Item>> unrentedMovies;
        private final Map<Integer, Map<Integer, Item>> shopMap;

        public MovieRentingSystem(int n, int[][] entries) {
            rentedMovies = new TreeSet<>(RENTED_COMPARATOR);
            unrentedMovies = new HashMap<>();
            shopMap = new HashMap<>();

            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];
                Item item = new Item(shop, movie, price);
                shopMap.computeIfAbsent(shop, k -> new HashMap<>()).put(movie, item);
                unrentedMovies.computeIfAbsent(movie, k -> new TreeSet<>(UNRENTED_COMPARATOR)).add(item);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();
            TreeSet<Item> set = unrentedMovies.get(movie);

            if (set == null) {
                return result;
            }

            int count = 0;

            for (Item item : set) {
                if (count == 5) {
                    break;
                }

                result.add(item.shopId());
                count++;
            }

            return result;
        }

        public void rent(int shop, int movie) {
            Item item = shopMap.get(shop).get(movie);
            unrentedMovies.get(movie).remove(item);
            rentedMovies.add(item);
        }

        public void drop(int shop, int movie) {
            Item item = shopMap.get(shop).get(movie);
            rentedMovies.remove(item);
            unrentedMovies.computeIfAbsent(movie, k -> new TreeSet<>(UNRENTED_COMPARATOR)).add(item);
        }

        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();
            int count = 0;

            for (Item item : rentedMovies) {
                if (count == 5) {
                    break;
                }

                result.add(List.of(item.shopId(), item.movieId()));
                count++;
            }

            return result;
        }

        private record Item(int shopId, int movieId, int price) {
        }
    }
}
