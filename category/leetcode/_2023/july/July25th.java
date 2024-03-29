package category.leetcode._2023.july;

public class July25th {
    public int peakIndexInMountainArray(final int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int mid = (start + end) / 2;

        while(start < end){
            if(arr[mid] > arr[mid + 1]){
                end = mid;
            }
            else{
                start = mid + 1;
            }
            mid = (start + end) / 2;
        }
        return end;
    }
}
