package features;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdef {
	String price;
	WebDriver driver = Hooks.driver;
	@Given("I have launched Pizzahutt application")
	public void i_have_launched_Pizzahutt_application() {
		// Write code here that turns the phrase above into concrete actions

		driver.get("https://www.pizzahut.co.in/order/deals/");
	}
	
	@When("I enter the location as {string}")
	public void i_enter_the_Location(String Location) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		WebElement Place = driver.findElement(By.xpath("//input[@placeholder='Enter your location for delivery']"));
		Place.sendKeys(Location);
		Thread.sleep(1000);
		
	}
	
	@When("I select the very first suggestion from the list")
	public void i_select_the_very_first_suggestion_from_List() throws InterruptedException {
		WebElement First=driver.findElement(By.xpath("(//button[@id='PlacesAutocomplete__suggestion-ChIJARFGZy6_wjsRQ-Oenb9DjYI'])[2]"));
		First.click();
		Thread.sleep(1000);
	}
	
	@Then("I should land on the Deals page with page url {string}")
	public void i_should_land_on_the_deals_page_with_page_url(String expectedUrl) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlContains("order/deals"));
	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals("User did not land on the expected Deals page.", expectedUrl, actualUrl);
	    System.out.println("User successfully landed on Deals page: " + actualUrl);
	}
	
	@When("I select the tab as {string}")
	public void i_select_the_tab(String tabName) {
	    String dynamicXpath = String.format("//a[.//span[normalize-space(text())='%s']]", tabName);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    By tabBy = By.xpath(dynamicXpath);

	    // Optional: Close any known popups that might block the tab
	    try {
	        WebElement popupCloseBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.popup-close, button.cookie-accept")));
	        popupCloseBtn.click();
	        // Wait a bit after closing popup
	        Thread.sleep(1000);
	    } catch (Exception e) {
	        // No popup found, continue
	    }

	    wait.until(ExpectedConditions.presenceOfElementLocated(tabBy));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(tabBy));

	    WebElement tabElement = driver.findElement(tabBy);

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);
	    wait.until(ExpectedConditions.elementToBeClickable(tabBy));
	    tabElement.click();
	}


	
	@When("I add Selected Pizza to the basket {string}")
	public void i_add_Selected_Pizza_to_the_basket(String pizzaName) {
	   
	 // Locate pizza by name
	    String pizzaXpath = String.format("//div[contains(@class,'list-item__name') and contains(normalize-space(.),'%s')]", pizzaName);
	    WebElement pizzaElement = driver.findElement(By.xpath(pizzaXpath));
	    
	 // Locate Add to Cart button (usually after price, may differ in DOM)
	    WebElement addToCartBtn = pizzaElement.findElement(By.xpath(".//following::button[contains(.,'Add') or contains(.,'ADD')][1]"));

	    // Scroll and click
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);
	    addToCartBtn.click();
	
	}
	
	
	@When("I note down the price displayed on the screen {string}")
	public void I_note_down_the_price_displayed_on_the_screen(String pizzaName) throws InterruptedException{
		
	    String pizzaXpath = String.format("//div[contains(@class,'list-item__name') and contains(normalize-space(.),'%s')]", pizzaName);
	    WebElement pizzaElement = driver.findElement(By.xpath(pizzaXpath));
		
		 WebElement priceElement = pizzaElement.findElement(By.xpath(".//following::span[contains(@class,'rupee')][1]"));
		     price = priceElement.getText();
		    System.out.println("Pizza: " + pizzaName + " | Price: " + price);
	}
	
	@Then("I should see the pizza {string} is added to the cart")
	public void iShouldSeeThePizzaIsAddedToTheCart(String pizzaName) {
	    WebElement editButton = driver.findElement(By.cssSelector("a.basket-item-product-edit-button[title='Click to make changes']"));
	    String href = editButton.getAttribute("href");
	    String expectedSlug = pizzaName.toLowerCase().replace(" ", "-");
	    Assert.assertTrue(href.contains(expectedSlug));
	}
	
	@Then("the price for the pizza is displayed as {string}")
	public void thePriceForThePizzaIsDisplayedAs(String price) {
		String expectedPrice= price;
	    WebElement priceElement = driver.findElement(By.cssSelector("span.subtotal"));
	    String actualPrice = priceElement.getText();
	    Assert.assertEquals(expectedPrice, actualPrice);
	}
	
	@When("I click on the Checkout button")
	public void iClickOnTheCheckoutButton() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Find the Checkout span
	    WebElement checkoutSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.xpath("//span[text()='Checkout']")
	    ));
	    checkoutSpan.click();
	}
		
	@Then("I should be landed on the secured checkout page with url {string}")
	public void iShouldBeLandedOnTheSecuredCheckoutPageWithUrl(String expectedUrl) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.urlToBe(expectedUrl));

	    String actualUrl = driver.getCurrentUrl();
	    Assert.assertEquals("URL did not match", expectedUrl, actualUrl);
	}
	
	@When("I enter the First Name {string}")
	public void enterFirstName(String firstName) {
	    WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='checkout__name']"));
	    firstNameInput.sendKeys(firstName);
	}

	@When("I enter the Mobile {string}")
	public void enterMobile(String mobile) {
	    WebElement mobileInput = driver.findElement(By.xpath("//input[@id='checkout__phone']"));
	    mobileInput.clear();
	    mobileInput.sendKeys(mobile);
	}

	@When("I enter the email {string}")
	public void enterEmail(String email) {
	    WebElement emailInput = driver.findElement(By.xpath("//input[@id='checkout__email']"));
	    emailInput.clear();
	    emailInput.sendKeys(email);
	}

	
}
