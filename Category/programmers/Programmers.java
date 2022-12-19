package Category.programmers;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers {

    static class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String message = br.readLine();
            System.out.println(solution(message));
        }
    }

    public static int solution(String message) {
        int answer = message.length() * 2;
        return answer;
    }
}