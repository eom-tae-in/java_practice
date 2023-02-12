package Category.programmers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 설계 계획
/*
1. set사용해서 겹치는거 있는지 확인 
1-1. 겹치는게 있는 경우, n과 같은 수 있지 확인, 확인 후 같다면 같기 전 숫자 리턴
2. 처음 값인지 끝 값인지 확인
2-1. 처음과 끝 값 중 하나라면 따로 뺀 로직 수행
3. normal한 숫자인 경우, 로직 수행
 */

public class Programmers {

    static final int MAXIMUMNUMBER = 2;
    static final int NOMALNUMBER = 1;
    static final int MINIMUMNUMBER = 0;

    static class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int indexLength = sc.nextInt();
            int[] array = new int[indexLength];
            for (int i = 0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            System.out.println(solution(array, n));
        }

        public static int solution(int[] array, int n) {
            Arrays.sort(array);
            if (checkDuplicate(array)) {
                return duplicateCase(array, n);
            }
            return numberIsNotDuplicatedCase(array, n);
        }

        public static boolean checkDuplicate(int[] array) {
            Set<Integer> set = new HashSet<>();
            for (int i : array) {
                set.add(i);
            }
            return set.size() != array.length;
        }

        public static int duplicateCase(int[] array, int n) {
            Set<Integer> set = findDuplicateNumberLocation(array);
            if (checkIsEqualsNumber(set, n)) {
                return numberIsDuplicatedCase(array, n);
            }
            return numberIsNotDuplicatedCase(array, n);
        }

        public static Set<Integer> findDuplicateNumberLocation(int[] array) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] == array[i + 1]) {
                    set.add(array[i]);
                }
            }
            return set;
        }

        public static boolean checkIsEqualsNumber(Set<Integer> set, int n) {
            for (Integer integer : set) {
                if (integer == n) {
                    return true;
                }
            }
            return false;
        }

        public static int numberIsDuplicatedCase(int[] array, int n) {
            int location = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == n) {
                    location = i - 1;
                }
            }
            return array[location];
        }

        public static int numberIsNotDuplicatedCase(int[] array, int n) {
            int location = findLocation(array, n);
            int kind = minimumOrMaximumOrNormal(location, array.length);
            if (kind == MAXIMUMNUMBER) {
                return maxCase(array);
            }
            if (kind == MINIMUMNUMBER) {
                return minCase(array);
            }
            return findCloseNumber(array, n, location);
        }

        public static int findLocation(int[] array, int n) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= n) {
                    return i;
                }
            }
            return array.length;
        }

        public static int minimumOrMaximumOrNormal(int location, int maximumCase) {
            if (location == 0) {
                return MINIMUMNUMBER;
            }
            if (location == maximumCase) {
                return MAXIMUMNUMBER;
            }
            return NOMALNUMBER;
        }

        public static int findCloseNumber(int[] array, int n, int location) {
            int previousCase = n - array[location - 1];
            int nextCase = array[location] - n;
            if (previousCase > nextCase) {
                return array[location];
            }
            if (previousCase < nextCase) {
                return array[location - 1];
            }
            return array[location - 1];
        }

        public static int maxCase(int[] array) {
            return array[array.length - 1];
        }

        public static int minCase(int[] array) {
            return array[0];
        }
    }
}