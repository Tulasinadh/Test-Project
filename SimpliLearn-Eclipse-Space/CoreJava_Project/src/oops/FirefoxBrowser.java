package oops;

public class FirefoxBrowser extends Browser {

	
	public void LaunchBrowser() {

		System.out.println("Launching the firefox browser");
	}
	
	// This is not overridden method
	public void OpenApplication(int application) {
		
		System.out.println("Opening the application");
	}
	
public void CloseBrowser() {
		
		System.out.println("closing the firefox browser");
		}

}
