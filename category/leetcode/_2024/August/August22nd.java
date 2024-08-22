package category.leetcode._2024.August;

public class August22nd {

    public int findComplement(int num) {
        for (long i = 1; i <= num; i <<= 1) {
            num ^= (int) i;
        }
        return num;
    }
}
