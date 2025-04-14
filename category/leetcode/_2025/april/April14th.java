package category.leetcode._2025.april;

public class April14th {

    public int countGoodTriplets(final int[] arr, final int a, final int b, final int c) {
        int answer = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
