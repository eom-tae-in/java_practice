package Category.baekjoon;

import java.util.List;

public class test {
    public static void main(String[] args) {

        System.out.println(solution(List.of(99, 100), List.of(211, 212)));

    }
    // 페이지가 올바른지
    // Max값을 찾기
    // Max값을 찾기 위해서 곱과 합 따로 계산하기
    // Max값을 찾은 후에 서로 비교해서 누가 더 값이 큰지 확인
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (!(correctPage(pobi) && correctPage(crong))) {
            return -1;
        }
        return compareMaxValue(pobi, crong);
    }

    public static boolean correctPage(List<Integer> name) {

        if (name.get(0) % 2 == 1 && name.get(1) - name.get(0) == 1) {
            return true;
        }
        return false;
    }

    public static int findMaxValue(Integer page) {

        return Math.max(addPageNumber(page), multiplyPageNumber(page));
    }

    public static int findMaxPage(List<Integer> name) {

        return Math.max(findMaxValue(name.get(0)), findMaxValue(name.get(1)));
    }

    public static int compareMaxValue(List<Integer> pobi, List<Integer> crong) {

        int pobiMaxValue = findMaxPage(pobi);
        int crongMaxValue = findMaxPage(crong);

        if (pobiMaxValue > crongMaxValue) {
            return 1;
        }
        if (pobiMaxValue < crongMaxValue) {
            return 2;
        }
        return 0;

    }

    public static int addPageNumber(Integer page) {

        int pageNumber = page;
        int sum = 0;
        while (pageNumber != 0) {
            sum += pageNumber % 10;
            pageNumber /= 10;
        }
        return sum;
    }

    public static int multiplyPageNumber(Integer page) {

        int pageNumber = page;
        int value = 1;
        while (pageNumber != 0) {
            value *= pageNumber % 10;
            pageNumber /= 10;
        }
        return value;
    }
}
