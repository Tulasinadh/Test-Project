package Testing;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeyboardExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement Query = driver.findElement(By.name("q"));
		Query.sendKeys("Nikunj");
		Query.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
		Query.sendKeys("Nikunj Shah");
	}



}
