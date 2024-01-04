package category.leetcode._2023.december;

import java.util.List;

public class December15th {

    public String destCity(final List<List<String>> paths) {
        String answer = "";

        for (final List<String> path : paths) {
            if (!hasNextCity(paths, path.get(1))) {
                answer = path.get(1);
            }
        }

        return answer;
    }

    private boolean hasNextCity(final List<List<String>> paths, final String currentCity) {

        return paths.stream()
                .anyMatch(path -> currentCity.equals(path.get(0)));
    }
}
