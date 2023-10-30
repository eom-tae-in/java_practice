package category.leetcode.september;

public class September19th {

    public int findDuplicate(int[] nums) {
        /*
         * 조건: 메모리를 오직 상수 공간으로만 사용해야 한다.(nums에 의존하지 않고 항상 동일한 상수 메모리 공간만 사용해야 한다.)
         * 플로이드의 토끼와 거북이 알고리즘 사용
         */
        int slow = nums[nums[0]];
        int fast = nums[nums[nums[0]]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
