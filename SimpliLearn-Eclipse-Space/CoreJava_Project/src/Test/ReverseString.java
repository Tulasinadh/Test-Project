package Test;

public class ReverseString {
	public static String Reverse(String word) {
		String rev = "";
		for (int i = word.length() - 1; i >= 0; i--) {
			char ch = word.charAt(i);
			rev = rev + ch;
		}
		return rev;
	}

	public static void main(String args[]) {
		String str1 = "This is Automation Testing Masters Program";
		
		String[] arr = str1.split(" ");
		for (String Word1 : arr) {
			String Arev = Reverse(Word1);
			Arev = Arev + " ";
			System.out.print(Arev);
		}
	}
}
