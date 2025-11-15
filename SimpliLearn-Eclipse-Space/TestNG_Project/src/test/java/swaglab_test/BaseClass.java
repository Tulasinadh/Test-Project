package swaglab_test;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	@BeforeMethod
	public void Setup() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		 driver = new ChromeDriver(options);
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
    @AfterMethod
	public void TearDown() {
		driver.close();
	}
	

}
