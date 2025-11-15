package Testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Integer> Numbers = new HashSet<>();
		
		Numbers.add(22);
		Numbers.add(67);
		Numbers.add(45);
		Numbers.add(27);
		
		System.out.println(Numbers);
		
		// Try adding 67 again
		
		Numbers.add(67);
		System.out.println(Numbers);
		
		
		//Convert Set into List
		List<Integer> NumbersList = new ArrayList<>(Numbers);
		
		Collections.sort(NumbersList);
		System.out.println(NumbersList);
		
		// No duplicate allowed in Set but in List we can
		// Set will not maintain the insertion order

	}



}
