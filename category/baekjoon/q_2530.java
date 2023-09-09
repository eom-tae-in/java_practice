package category.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_2530 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        if(z+time >= 60){
            y += (z+time)/60;
            z = (z+time)%60;
        }
        else{
            z += time;
        }
        if(y >= 60){

            x += y/60;
            y = y%60;
        }

        if(x >= 24){

            x = x%24;
        }

        System.out.println(x + " " + y + " " + z);

    }

}
