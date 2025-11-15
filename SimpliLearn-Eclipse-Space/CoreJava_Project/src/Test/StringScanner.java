package Test;

import java.util.Scanner;

public class StringScanner {
	public static void main(String args[]) {
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
		System.out.println();

		Scanner sc =new Scanner(System.in);
		System.out.println("Enter String1 value");
		String  name1=sc.nextLine();
		System.out.println("Enter String2 value");
		String  name2=sc.nextLine();
		if(name1.equals(name2))
			System.out.println("Strings matches");
		else
			System.out.println("Strings does not matches");	
		
	}

}
