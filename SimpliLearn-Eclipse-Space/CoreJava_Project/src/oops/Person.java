package oops;

public class Person {

	String name;
	int ssn;
	int age;
	String city;
	static String country = "United States";

	// constructor is a special method having name same as class
	// constructor will never return any value
	
	public Person(String p1, int p2, int p3, String p4) {
		
		name = p1;
		ssn = p2;
		age = p3;
		city = p4;
		
	}
	
	public void displayData() {
		
		System.out.println(name);
		System.out.println(ssn);
		System.out.println(age);
		System.out.println(city);	
System.out.println(Person.country);	
	}

}
