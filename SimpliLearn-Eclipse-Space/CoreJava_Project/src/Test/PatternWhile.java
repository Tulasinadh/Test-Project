package Test;

public class PatternWhile {
	public static void main(String[] args) {

		for (int row = 6; row >= 1; row--) {
			int col = 1;
			while (col <= row) {
				System.out.print("*");
				col++;
			}
			System.out.println();
		}

	}

}
