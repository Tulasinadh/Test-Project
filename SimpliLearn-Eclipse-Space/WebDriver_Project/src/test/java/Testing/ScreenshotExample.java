package Testing;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScreenshotExample {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement Source = driver.findElement(By.xpath("//div[text()='Drag me']"));
		WebElement Target = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(Source, Target).build().perform();
		
		TakesScreenshot obj = (TakesScreenshot) driver;
		File image = obj.getScreenshotAs(OutputType.FILE);
		File target = new File("screenshot.png");
		
		FileUtils.copyFile(image, target);
		
	}


}
