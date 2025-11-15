package Test;

import java.util.Scanner;

public class ConditionsExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x ;
		int y ;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the value of x:");
		x = s.nextInt();
		
		System.out.println("Enter the value of y:");
		y = s.nextInt();

		if (x == y) {
			System.out.println("Matching");
		} else {
			System.out.println("Not Matching");
		}

	}


}
