package oops;

public class AccesModifier {
	
	String name;   		// default access modifier
	public int rollNo;  // public access modifier
	protected int grade;  // protected access modifier
	private String school;  // private access modifier
	
	
	// 1. default members can be accessed only in same class 
	// or different class in same package

	
	//2. public members can be accessed from anywhere in the project
	
	//3. protected members can be access from same class
	// or different class in same package
	// or from the subclass
	
	//4. private members can be accessed only from the same class
	
	public String getSchoolName() {
		
		return school;
	}
	
	public void setSchoolName(String name) {
		
		school = name;	
	}
	
	



}
