package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchBrowserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	WebDriver driver = new ChromeDriver();
		WebDriver driver = new EdgeDriver();
		driver.get("https://simplilearn.com/");
		driver.manage().window().maximize();
		driver.close();

	}
}

