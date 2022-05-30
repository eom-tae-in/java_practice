package Category.Math;
import java.util.Scanner;

public class q_1712 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (c <= b) {
            System.out.println("손익분기점을 찾을 수 없습니다.");
        }
        else {
            System.out.println((a/(c-b)) + 1);
        }
    }
}
