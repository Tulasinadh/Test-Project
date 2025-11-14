package swaglab_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import swaglab_pages.LoginPage;
import swaglab_pages.ProductsPage;

public class ProductsTest extends BaseClass{
	
	@Test
	public void AddtoCartTest() throws InterruptedException {
		String PName="Sauce Labs Bolt T-Shirt";
		
		LoginPage lp = new LoginPage();
		lp.LoginFunction("standard_user", "secret_sauce");
		
		ProductsPage pp = new ProductsPage();
		pp.AddToCart(PName);
		Thread.sleep(1000);
		
		pp.CartValidation(PName);
		Thread.sleep(1000);
		
	}

}
