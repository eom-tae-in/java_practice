package category.leetcode._2025.october;

public class October23rd {

    public boolean hasSameDigits(String s) {
        int n = s.length();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int currN = n;

        while (currN - 2 > 0) {
            for (int i = 1; i < currN; i++) {
                arr[i - 1] = (arr[i - 1] + arr[i]) % 10;
            }

            currN--;
        }

        return arr[0] == arr[1];
    }
}
