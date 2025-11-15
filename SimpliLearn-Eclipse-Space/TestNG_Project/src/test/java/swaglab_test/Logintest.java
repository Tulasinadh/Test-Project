package swaglab_test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import swaglab_pages.LoginPage;



public class Logintest extends BaseClass {
	
	@Test(priority=0)
	public void LoginSuccessTest() throws InterruptedException {
		
		/*String env = System.getenv("ENV");

		if(env.equals("Dev")) {

			throw new SkipException("Skipping the test case beacuse env is Dev");

		}
		*/
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_sauce");
		
	 WebElement ProductTitle = driver.findElement(By.className("title"));
		Assert.assertEquals(ProductTitle.getText(), "Products");
	 
	}
	
	@Test(priority= 1)
	public void LoginFailureTest() throws InterruptedException {
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_test");
		
		 WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
			Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Username and password do not match any user in this service");
		 
	}
	
	
	@Test 
	public void LockedUserLoginFailureTest() throws InterruptedException {	
			 
				LoginPage lp = new LoginPage();
				lp.LoginFunction("locked_out_user", "secret_sauce");
			
		WebElement ErrorMsg = driver.findElement(By.xpath("//h3[@data-test='error']"));
		Assert.assertEquals(ErrorMsg.getText(), "Epic sadface: Sorry, this user has been locked out.");
		
	}
	
	
	


}
