package Test;

public class ArrayClass {
public static void main( String args[]) {
		// TODO Auto-generated method stub
		
		int[] numbers = {4,5,63,56,78,45};
	
		String[] names = {"Rahul","James", "Priya", "Greg"};
		
		System.out.println("First value " + numbers[0] );
		System.out.println("Second value " + numbers[1] );
		
		System.out.println("Total values " + numbers.length);
		
		char[] vowels = {'a', 'e' ,'i','o','u'};
		
		String str1 = "This is sample string";
		
		//create the array of words from above string
		
		String[] words = str1.split(" "); // {"This","is"."sample","string"}
		
		System.out.println(words[3]);
		
		//================================================================
		
		String str2 = "Today is Sunday and I am feeling lucky";
		
		//String out1 = "Today is Sunday";
		//String out2 = "I am feeling lucky";
		
		String out1 = str2.split("and")[0]; //{"Today is Sunday", "I am feeling lucky"}
		String out2 = str2.split("and")[1];
		
		System.out.println(out1.trim()); // remove the spaces from start and at the end
		System.out.println(out2.trim());

}
}
