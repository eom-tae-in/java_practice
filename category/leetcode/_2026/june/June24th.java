package category.leetcode._2026.june;

public class June24th {

    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int valueRange = r - l + 1;

        if (valueRange == 1) {
            return n == 1 ? 1 : 0;
        }

        int sequenceLength = valueRange * 4 + 10;
        long[] sequence = buildSequence(sequenceLength, valueRange);
        long[] recurrenceCoefficients = berlekampMassey(sequence);
        long[] initialTerms = new long[recurrenceCoefficients.length];
        System.arraycopy(sequence, 0, initialTerms, 0, initialTerms.length);

        return (int) linearRecurrence(initialTerms, recurrenceCoefficients, n - 1L);
    }

    private long[] buildSequence(int sequenceLength, int valueRange) {
        long[] sequence = new long[sequenceLength];
        sequence[0] = valueRange;
        long[] increasingEndCount = new long[valueRange];
        long[] decreasingEndCount = new long[valueRange];

        for (int value = 0; value < valueRange; value++) {
            increasingEndCount[value] = value;
            decreasingEndCount[value] = valueRange - 1 - value;
        }

        sequence[1] = (long) valueRange * (valueRange - 1) % MOD;

        for (int length = 2; length < sequenceLength; length++) {
            long[] nextIncreasingEndCount = new long[valueRange];
            long[] nextDecreasingEndCount = new long[valueRange];
            long decreasingPrefixSum = 0;

            for (int value = 0; value < valueRange; value++) {
                nextIncreasingEndCount[value] = decreasingPrefixSum;
                decreasingPrefixSum = (decreasingPrefixSum + decreasingEndCount[value]) % MOD;
            }

            long increasingSuffixSum = 0;

            for (int value = valueRange - 1; value >= 0; value--) {
                nextDecreasingEndCount[value] = increasingSuffixSum;
                increasingSuffixSum = (increasingSuffixSum + increasingEndCount[value]) % MOD;
            }

            increasingEndCount = nextIncreasingEndCount;
            decreasingEndCount = nextDecreasingEndCount;
            long totalCount = 0;

            for (int value = 0; value < valueRange; value++) {
                totalCount = (totalCount + increasingEndCount[value] + decreasingEndCount[value]) % MOD;
            }

            sequence[length] = totalCount;
        }

        return sequence;
    }

    private long[] berlekampMassey(long[] sequence) {
        long[] recurrence = new long[sequence.length + 1];
        long[] previousRecurrence = new long[sequence.length + 1];
        recurrence[0] = 1;
        previousRecurrence[0] = 1;
        int recurrenceDegree = 0;
        int shift = 1;
        long lastDiscrepancy = 1;

        for (int currentIndex = 0; currentIndex < sequence.length; currentIndex++) {
            long discrepancy = 0;

            for (int i = 0; i <= recurrenceDegree; i++) {
                discrepancy = (discrepancy + recurrence[i] * sequence[currentIndex - i]) % MOD;
            }

            if (discrepancy == 0) {
                shift++;
                continue;
            }

            long[] previousState = recurrence.clone();

            long scaleFactor = discrepancy * modPow(lastDiscrepancy, MOD - 2) % MOD;

            for (int i = 0; i + shift < recurrence.length; i++) {
                recurrence[i + shift] = (recurrence[i + shift] - scaleFactor * previousRecurrence[i]) % MOD;

                if (recurrence[i + shift] < 0) {
                    recurrence[i + shift] += MOD;
                }
            }

            if (2 * recurrenceDegree <= currentIndex) {
                recurrenceDegree = currentIndex + 1 - recurrenceDegree;
                previousRecurrence = previousState;
                lastDiscrepancy = discrepancy;
                shift = 1;
            } else {
                shift++;
            }
        }

        long[] recurrenceCoefficients = new long[recurrenceDegree];

        for (int i = 0; i < recurrenceDegree; i++) {
            recurrenceCoefficients[i] = (MOD - recurrence[i + 1]) % MOD;
        }

        return recurrenceCoefficients;
    }

    private long linearRecurrence(long[] initialTerms, long[] recurrenceCoefficients, long targetIndex) {
        int degree = recurrenceCoefficients.length;

        if (targetIndex < initialTerms.length) {
            return initialTerms[(int) targetIndex];
        }

        long[] resultPolynomial = new long[degree];
        long[] exponentPolynomial = new long[degree];
        resultPolynomial[0] = 1;

        if (degree == 1) {
            exponentPolynomial[0] = recurrenceCoefficients[0];
        } else {
            exponentPolynomial[1] = 1;
        }

        while (targetIndex > 0) {
            if ((targetIndex & 1) == 1) {
                resultPolynomial = combinePolynomials(resultPolynomial, exponentPolynomial, recurrenceCoefficients);
            }

            exponentPolynomial = combinePolynomials(exponentPolynomial, exponentPolynomial, recurrenceCoefficients);
            targetIndex >>= 1;
        }

        long answer = 0;

        for (int i = 0; i < degree; i++) {
            answer = (answer + resultPolynomial[i] * initialTerms[i]) % MOD;
        }

        return answer;
    }

    private long[] combinePolynomials(long[] firstPolynomial, long[] secondPolynomial, long[] recurrenceCoefficients) {
        int degree = recurrenceCoefficients.length;
        long[] multipliedPolynomial = new long[degree * 2];

        for (int i = 0; i < degree; i++) {
            for (int j = 0; j < degree; j++) {
                multipliedPolynomial[i + j] =
                        (multipliedPolynomial[i + j] + firstPolynomial[i] * secondPolynomial[j]) % MOD;
            }
        }

        for (int i = degree * 2 - 2; i >= degree; i--) {
            for (int j = 1; j <= degree; j++) {
                multipliedPolynomial[i - j] =
                        (multipliedPolynomial[i - j] + multipliedPolynomial[i] * recurrenceCoefficients[j - 1]) % MOD;
            }
        }

        long[] reducedPolynomial = new long[degree];
        System.arraycopy(multipliedPolynomial, 0, reducedPolynomial, 0, degree);

        return reducedPolynomial;
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}
