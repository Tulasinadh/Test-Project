package Test;

public class LoopsExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// while loop

		int x = 13;
		int y = 1;

		while (y <= 10) {

			int result = x * y;
			System.out.println(result);
			y = y + 1;
		}
		
		System.out.println("end of while loop");
		
		// print the table using for loop
		
		for (int i = 1; i <= 10; i++) {

			System.out.println(x * i);
		}
		
		System.out.println("end of for loop");
		
		// ======================
		// for each loop

				String[] names = { "Jon", "Adam", "Eva", "Nancy" };

				for (String str : names) {
					System.out.println(str);
				}

				// same this using normal for loop
				for (int i = 0; i < names.length; i++) {
					System.out.println(names[i]);
				}


	}



}
