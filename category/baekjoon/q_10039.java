package category.baekjoon;

import java.util.Scanner;

public class q_10039 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int sum = 0 ;
        for(int i = 0; i < 5; i++) {

            int val = sc.nextInt();

			  if(val > 40){
			 	sum += val;
			  } else {
			  	sum += 40;
			  }


        }
        System.out.println(sum/5);
    }

}
