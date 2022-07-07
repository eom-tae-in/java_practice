package Category.Math;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class q_1037 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int M = Integer.MIN_VALUE;
        int m = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        while(T-- > 0) {
            int N = Integer.parseInt(st.nextToken());
            M = Math.max(N, M);
            m = Math.min(N, m);
        }
        System.out.println(M * m);
    }

}
