package Testing;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsExample {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement Btn1 = driver.findElement(By.id("alertButton"));
		Btn1.click();

		Alert alt1 = driver.switchTo().alert();
		Thread.sleep(5000);
		alt1.accept();

		// Click cancel on the pop up
		WebElement Btn3 = driver.findElement(By.id("confirmButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Btn3);
		Btn3.click();

		Alert alt3 = driver.switchTo().alert();
		alt3.dismiss();

		// Enter the message on pop up box
		WebElement Btn4 = driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Btn4);
		Btn4.click();
		
		Alert alt4 = driver.switchTo().alert();
		alt4.sendKeys("Type Something");
		alt4.accept();
		
	}


}
