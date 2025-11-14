package TestNG;

import org.testng.annotations.Test;

public class AnnotationsExample2 extends BaseClass {
	
	@Test(groups ={"Sanity"})
	public void test3() {
		System.out.println("Inside Test Case 3");
	}

}
