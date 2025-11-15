package TestNG;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AnotationExmaple extends BaseClass {
	

	@Test(groups= {"Sanity"})
	public void test1() {
		System.out.println("Inside Test Case 1");
	}
	
	@Test(enabled=false)
	public void test2() {
		System.out.println("Inside Test Case 2");
	}
	
	

}
