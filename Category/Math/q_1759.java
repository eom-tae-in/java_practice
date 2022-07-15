package Category.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q_1759 {

    static int A, B;
    static char[] x;

    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        boolean[] check = new boolean[B];
        x = new char[B];

        arr = new char[B];

        st = new StringTokenizer(br.readLine()," ");

        for (int i = 0; i < B; i++){

            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        if(!CH(arr)){

            System.out.println("암호를 구할 수 없습니다.");
        }



        back(check, 0, 0);


        System.out.println(sb);

    }

    public static void back(boolean[] check, int index, int k){

        if (index == A && CH(x)){
            for (int i = 0; i < A; i++){
                sb.append(x[i]);
            }
            sb.append("\n");
            return;
        }


        for (int i = k; i < B; i++){

            if(check[i]){
                continue;
            }

            check[i] = true;
            x[index] = arr[i];
            back(check, index + 1, i+1);
            check[i] = false;
        }
    }

    public static boolean CH(char[] x){

        if (x.length < 3){

            return false;
        }

        int[] key = new int[A];

        for (int i = 0; i < A; i++){

            key[i] = x[i] - 'a';

            if (key[i] == 0 || key[i] == 4 ||  key[i] == 8 || key[i] == 14 ||  key[i] == 20){
                return true;
            }
        }
        return false;
    }

}
