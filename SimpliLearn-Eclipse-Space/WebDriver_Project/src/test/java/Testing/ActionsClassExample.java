package Testing;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassExample {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement Source = driver.findElement(By.xpath("//div[text()='Drag me']"));
		WebElement Target = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(Source, Target).build().perform();

	}



}
