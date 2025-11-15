package Test;

public class FibnocciSeries {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num1 = 0;
		int num2 = 1;
		int i = 0;

		while (i < 10) {

			int result = num1 + num2;
			System.out.print(result + " ");
			num1 = num2;
			num2 = result;
			i++;
		}

	}


}
