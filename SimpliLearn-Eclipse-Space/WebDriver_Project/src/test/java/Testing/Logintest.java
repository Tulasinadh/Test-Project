package Testing;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Logintest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		// Tag Locator
		WebElement Header = driver.findElement(By.tagName("h1"));
		String HeaderVal = Header.getText();
		System.out.println(HeaderVal);
		
		
		// 1. Link text locator
		WebElement LoginLink = driver.findElement(By.linkText("Login"));
		LoginLink.click();
		
		// 2. Name locator
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
		
		// 3. Id locator
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abcf@1234");
		
		// 4. Class locator
		WebElement RememberMe = driver.findElement(By.className("rememberMe"));
		RememberMe .click();
		
		WebElement LoginBtn = driver.findElement(By.name("btnlogin"));
		LoginBtn.click();
		
		// Print the error message
		WebElement Error = driver.findElement(By.id("msg_box"));
		String ErrorMsg = Error.getText();
		System.out.println("Error message is " + ErrorMsg);
		
		// Print the title
		String Title = driver.getTitle();
		System.out.println(Title);
		
		// Print the current url
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		
		// Partial link text locator
		WebElement ForgotPwd = driver.findElement(By.partialLinkText("Forgot "));
		ForgotPwd.click();
		
		

	}

}
