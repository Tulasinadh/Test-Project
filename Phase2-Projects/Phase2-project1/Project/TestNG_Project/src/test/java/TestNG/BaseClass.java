package TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	@BeforeTest(alwaysRun=true)
	public void Test1() {
		System.out.println(" Inside Before Test 1");
	}
	
	@AfterTest(alwaysRun=true)
	public void Test2() {
		System.out.println(" Inside After Test 2");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void Method1() {
		System.out.println(" Inside Befor TestMethod 1");
	}
	@AfterMethod(alwaysRun=true)
	public void Method2() {
		System.out.println(" Inside After TestMethod 2");
	}

}
