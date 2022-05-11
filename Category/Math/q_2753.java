package Category.Math;
import java.util.Scanner;
public class q_2753 {

    public static void main(String[] args) {


        int e = 0;

        Scanner input = new Scanner(System.in);

        int years = input.nextInt();

        if ((years % 4 == 0 && years % 100 != 0) || years % 400 == 0) {

            e = 1;
        } else {
            e = 0;
        }

        System.out.println(e);
    }
}
