package category.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_6603 {
    static int[] X;
    static int[] result;
    static int k;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) {
                break;
            }
            result = new int[k];
            X = new int[k];
            for(int i = 0; i < k; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            } 
            dfs(0, 0);

            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 백트래킹
    private static void dfs(int start, int depth) {
        if(depth == 6) {
            print();
        }
        for(int i = start; i < k; i++) {
            result[i] = 1;
            dfs(i+1, depth+1);
            result[i] = 0;
        }
    }

    private static void print() {
        for(int i =0; i < k; i++) {
            if(result[i] == 1) {

                sb.append(X[i]).append(" ");
            }
        }
        sb.append("\n");
    }

}
