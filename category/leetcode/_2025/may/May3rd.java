package category.leetcode._2025.may;

public class May3rd {

    public int minDominoRotations(final int[] tops, final int[] bottoms) {
        int dominoLength = tops.length;
        int[] bottomSum = new int[7];
        int[] topSum = new int[7];
        int[] bothSum = new int[7];

        for (int i = 0; i < dominoLength; i++) {
            topSum[tops[i]]++;
            bottomSum[bottoms[i]]++;

            if (tops[i] == bottoms[i]) {
                bothSum[tops[i]]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (topSum[i] + bottomSum[i] - bothSum[i] == dominoLength) {
                return dominoLength - Math.max(topSum[i], bottomSum[i]);
            }
        }

        return -1;
    }
}
