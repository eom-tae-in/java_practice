package Category.leetcode;

import java.util.Arrays;

public class July19rd {
    public int eraseOverlapIntervals(final int[][] intervals) {
        int count = 0;
        int end = Integer.MIN_VALUE;

        Arrays.sort(intervals, (o1, o2) -> o1[1]!=o2[1] ? o1[1] - o2[1] : o2[0] - o1[0]);

        for(int[] interval : intervals){
            if(interval[0] >= end){
                end = interval[1];
            }
            else{
                count++;
            }
        }
        return count;
    }
}
