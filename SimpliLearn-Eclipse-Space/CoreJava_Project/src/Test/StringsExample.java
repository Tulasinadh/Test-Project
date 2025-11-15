package Test;

public class StringsExample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("James Bond");
		System.out.println("James");
		System.out.println("Bond");
		
		String fName = "James";
		String lName = "Bond";
		char space = ' ';
		
		System.out.println(fName);
		System.out.println(lName);
		
		String fullName = fName + space + lName;
		System.out.println(fullName);
		
		System.out.println("Total chars in full name is " + fullName.length());
System.out.println("First char in full name is " + fullName.charAt(0));
		System.out.println("Second char in full name is " + fullName.charAt(1));
		String newName = fullName.replace("Bond", "Scott");
		System.out.println(newName);



	}

}
