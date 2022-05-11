package Category.Sorting;
import java.util.Scanner;
public class BubbleSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = n;
        int array[] = new int [t];

        for(int i=0; i<n; i++) {
            array[i] = scanner.nextInt();
        }

        for(int i=0; i<n-1; n--) {
            for (int j=0; j<n-1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = array[j];
                }
            }
            i++;
        }

        for (int i =0; i<t; i++){

            System.out.println(array[i]);
        }







        }
}
