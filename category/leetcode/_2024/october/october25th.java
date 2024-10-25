package category.leetcode._2024.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class october25th {

    public List<String> removeSubfolders(final String[] folder) {
        List<String> answer = new ArrayList<>();
        String prev = "";
        Arrays.sort(folder);

        for (String path : folder) {
            if (!prev.isEmpty() && path.startsWith(prev) && path.charAt(prev.length()) == '/') {
                continue;
            }

            answer.add(path);
            prev = path;
        }

        return answer;
    }
}
