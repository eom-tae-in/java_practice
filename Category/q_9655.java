package Category;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q_9655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        if (A % 2 == 1){

            System.out.println("SK");
        }
        else {

            System.out.println("CY");
        }
    }
}
