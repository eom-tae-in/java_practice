package category.leetcode._2024.august;

public class August7th {
    public String numberToWords(final int num) {
        return num == 0 ? "Zero" : helper(num);
    }

    private String helper(final int num) {
        String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        StringBuilder stringBuilder = new StringBuilder();
        if (num < 20) {
            stringBuilder.append(belowTwenty[num]);
        } else if (num < 100) {
            stringBuilder.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
        } else if (num < 1000) {
            stringBuilder.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num < 1000000) {
            stringBuilder.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num < 1000000000) {
            stringBuilder.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else {
            stringBuilder.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        }

        return stringBuilder.toString().trim();
    }
}
