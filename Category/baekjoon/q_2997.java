package Category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_2997 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        int[] distance = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < 3; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < 2; i++){

            distance[i] = arr[i+1] - arr[i];
        }

        Arrays.sort(distance);

        if (distance[0] == distance[1]){
                                                      // distance가 같다면 정답이 2개일 수 있다.
            System.out.println(arr[2] + distance[1]); // 문제에서 정답이 여러 개일 경우 아무거나 출력하면 된다는 조건이 있어서
        }                                             // 가장 큰 값의 다음 등차수열을 이루는 값으로 출력을 해준다.

        else {
            for (int i = 0; i < 2; i ++){

                if (arr[i+1] - arr[i] != distance[0]){

                    System.out.println(arr[i] + distance[0]);
                }
            }
        }
    }
}
