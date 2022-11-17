package Category.baekjoon;

import javax.print.DocFlavor;

/*
longTextDeduplication -> 문자열의 크기가 3이상일 때 중복이 모두 제거될 때까지 중복 제거
shortTextDeduplication   -> 문자열의 크기가 3미만일 때 중복이 모두 제거 되거나, 문자열 길이가 0이 될 때 까지 중복 제거
checkModify -> precheck와 currentcheck가 다르면 항상 현재 비교하려는 문자가 중복되는 문자이기 때문에 precheck와 currentcheck가 다른지 boolean타입으로 리턴
checkDuplicate -> pre(문자열의 i번째 문자), current(문자열의 i+1번째 문자)가 같은면 true 리턴
 */
public class test2 {

    static StringBuilder sb = new StringBuilder();
    static boolean checkModifyText;
    static boolean checkPre;
    static boolean checkCurrent;
    static boolean checkNotLowerCase;

    public static void main(String[] args) {
        System.out.println(solution("aaaaaaa"));
    }

    public static String solution(String cyptogram) {

        if (exceptionMethod(cyptogram)) {
            return cyptogram;
        }
        do {
            cyptogram = (cyptogram.length() >= 3 ? longTextDeduplication(cyptogram) : shortTextDuplication(cyptogram));
        } while (checkModifyText);
        return cyptogram;
    }

    public static String longTextDeduplication(String cryptogram) {

        sb.setLength(0);

        checkPre = false;
        checkCurrent = false;
        checkModifyText = false;

        initailValue(cryptogram);

        checkPre = checkCurrent;

        for (int i = 1; i < cryptogram.length() - 1; i++) {

            checkCurrent = checkDuplicate(cryptogram.charAt(i), cryptogram.charAt(i + 1));
            if (checkPre == checkCurrent && !checkCurrent) {
                sb.append(cryptogram.charAt(i));
            }
            verifyStringChange();
            checkPre = checkCurrent;
        }
        lastValue(cryptogram);
        return String.valueOf(sb);
    }

    public static String shortTextDuplication(String cryptogram) {

        sb.setLength(0);

        checkCurrent = false;
        checkModifyText = false;

        if (cryptogram.length() == 2) {

            checkCurrent = checkDuplicate(cryptogram.charAt(0), cryptogram.charAt(1));

            if (!checkCurrent) {
                sb.append(cryptogram.charAt(0)).append(cryptogram.charAt(1));
            }
            return String.valueOf(sb);
        }
        return cryptogram;
    }


    public static Boolean checkModify(boolean checkPre, boolean checkCurrent) {

        return checkCurrent || checkPre != checkCurrent;
    }

    public static Boolean checkDuplicate(char pre, char current) {

        return pre == current;
    }

    public static void initailValue(String cryptogram) {
        checkCurrent = checkDuplicate(cryptogram.charAt(0), cryptogram.charAt(1));
        if (!checkCurrent) {
            sb.append(cryptogram.charAt(0));
        }
    }

    public static void lastValue(String cryptogram) {
        if (!checkPre) {
            sb.append(cryptogram.charAt(cryptogram.length() - 1));
        }
    }

    public static void verifyStringChange() {
        if (checkModify(checkPre, checkCurrent)) {
            checkModifyText = true;
        }
    }
    public static boolean exceptionMethod(String cyptogram) {
        if (isIncludedNotLowerCase(cyptogram) || stringLengthException(cyptogram)) {
            System.out.println("잘못된 입력입니다.");
            return true;
        }
        return false;
    }
    public static boolean stringLengthException(String cyptogram) {

        return cyptogram.length() < 1 || cyptogram.length() > 1000;
    }
    public static boolean isIncludedNotLowerCase(String crytogram) {

        checkNotLowerCase = false;

        for (int i = 0; i < crytogram.length(); i++) {
            if (crytogram.charAt(i) < 97 || crytogram.charAt(i) > 122) {
                checkNotLowerCase = true;
                break;
            }
        }
        return checkNotLowerCase;
    }
}
