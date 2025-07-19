package category.leetcode._2025.july;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class July19th {

    public List<String> removeSubfolders(String[] folder) {
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
