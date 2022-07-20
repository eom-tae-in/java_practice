package Category;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q_1002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){

            st = new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            double f = Double.parseDouble(st.nextToken());

            double distance = Math.sqrt(Math.pow(a-d,2) + Math.pow(b-e,2));

            if (a == d && b == e){
                if(c == f){
                    sb.append(-1).append("\n");
                    break;
                }
                sb.append(0).append("\n");
            }

            else if (distance > c+f){
                    sb.append(0).append("\n");
            }
            else if (distance + Math.min(c, f) < Math.max(c, f)) {
                    sb.append(0).append("\n");
            }
            else if (distance == c+f) {
                    sb.append(1).append("\n");
            }
            else if (distance == (Math.max(c,f) - Math.min(c,f))){
                    sb.append(1).append("\n");
                }

            else {
                    sb.append(2).append("\n");

                }

        }
        System.out.println(sb);
    }
}
