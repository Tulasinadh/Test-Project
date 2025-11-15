package swaglab_pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import swaglab_test.BaseClass;

public class ProductsPage {

WebDriver driver = BaseClass.driver;
	
	
	//============ Locators ==============
	
	@FindBy(xpath = "//a[@data-test='shopping-cart-link']")
	WebElement CartIcon;
	
	
	//============= Methods ===============
	
	public ProductsPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void AddToCart(String ProductName) {
		
		String ProductXapth = "//div[text()='" + ProductName + "']//following::button[1]";
		
		WebElement AddToCart = driver.findElement(By.xpath(ProductXapth));
		AddToCart.click();
	}

public void CartValidation(String ProductName) {
		
	CartIcon.click(); 
	 boolean found = false;

	 for (int i = 1; i > 0; i++) {
	     try {
	         String CartItemVali = "(//div[@class='cart_item_label'])[" + i + "]//a//div[1]";
	         WebElement CartIV = driver.findElement(By.xpath(CartItemVali));
	         String actualProductName = CartIV.getText();

	         if (actualProductName.equals(ProductName)) {
	             Assert.assertEquals(actualProductName, ProductName, "Product name in cart does not match expected");
	             found = true;
	             break;
	         }
	     } catch (NoSuchElementException e) {
	         // No more cart items — exit loop
	         break;
	     }
	 }

	 Assert.assertTrue(found, "Expected product '" + ProductName + "' was not found in the cart.");

	
	}
	
}
