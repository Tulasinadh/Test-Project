package Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListExamples {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> Names = new ArrayList<>();

		Names.add("Priya");
		Names.add("Rohan");
		Names.add("Macky");

		System.out.println(Names);

		System.out.println("Total names are " + Names.size());
		System.out.println("First names is " + Names.get(0));

		// Remove the data - Rohan
		Names.remove(1);
		System.out.println(Names);

		// Add one more student to the list
		Names.add("Nivetha");
		System.out.println(Names);

		// Update the data
		Names.set(1, "Mike");
		System.out.println(Names);

		// Iterate through the array list

		for (String n : Names) {
			System.out.println(n);
		}

		// Using for loop
		for (int i = 0; i < Names.size(); i++) {
			System.out.println(Names.get(i));
		}
		
		Names.add("Priya");
		System.out.println(Names);
		
		// To Sort the ArrayList
		Collections.sort(Names);
		System.out.println(Names);
		
		
		// Concatenate Two Lists
		List<String> Names2 = new ArrayList<>();

		Names2.add("Apoorva");
		Names2.add("Nikhil");
		
		Names.addAll(Names2);
		System.out.println(Names);
		
		// Validate that Nikhil is present in the Array List
		if(Names.contains("Nikhil")) {
			System.out.println("Present");
		}else {
			System.out.println("Not Present");
		}
		

	}


}
