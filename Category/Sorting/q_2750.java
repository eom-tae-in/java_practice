package Category.Sorting;
import java.util.Scanner;
public class q_2750 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] array = new int[n];

        for (int i= 0; i<n; i++){

            array[i]=scanner.nextInt();

        }

        for (int i= 0; i<n; i++){
            for(int j=i+1; j<n; j ++){

                if(j==n){
                    break;
                }
                if (array[i]>array[j]){
                    int temp =  array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

            System.out.println(array[i]);

        }
    }
}
