package category.leetcode._2024.october;

public class October9th {

    public int minAddToMakeValid(final String s) {
        int require = 0;
        int prefix = 0;
        int suffix = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                prefix++;
            } else {
                if (prefix <= suffix) {
                    require++;
                } else {
                    suffix++;
                }
            }
        }
        require += (prefix - suffix);

        return require;
    }
}
