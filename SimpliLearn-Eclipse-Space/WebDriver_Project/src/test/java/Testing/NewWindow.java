package Testing;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class NewWindow {
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement winbtn = driver.findElement(By.xpath("//button[@id='windowButton']"));
		winbtn.click();
		List<String> AllWin = new ArrayList<>(driver.getWindowHandles());
		String Parent = AllWin.get(0);
		String Child = AllWin.get(1);
		driver.switchTo().window(Child);
		WebElement Header = driver.findElement(By.tagName("h1"));
		System.out.println(Header.getText());
		// only close the current window
				driver.close();
				driver.switchTo().window(Parent);
	}
	

}
