package Category.baekjoon;

import java.util.Scanner;

public class q_2622 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int count = 0;

        if (T == 1 || T == 2 || T == 4){
            System.out.println(0);
        }
        else { // 삼각형은 가장 큰 변의 길이가 다른 두변의 길이를 더한거 보다 클 수 없다.
            for (int i = 1; i <= T/3; i++){
                int sum = T - i;
                for (int j = i; j <= sum / 2; j++){

                    int s = sum - j;

                    if (s < j + i){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
