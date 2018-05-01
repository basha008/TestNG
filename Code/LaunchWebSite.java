package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchWebSite {

	public static void SetPropertiesofChromeBrowser(String driverfileLocation) {
		System.setProperty("webdriver.chrome.driver", driverfileLocation);
	}

	public void SetPropertiesofhFireFoxBrowser(String driverfileLocation) {
		System.setProperty("webdriver.gecko.driver", driverfileLocation);
	}

	public void SetPropertiesofIEBrowser(String driverfileLocation) {
		System.setProperty("webdriver.ie.driver", driverfileLocation);
	}

	public static WebDriver LaunchUrlinChrome(String Url) {
		WebDriver driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver LaunchUrlinFireFox(String Url) {
		WebDriver driver = new FirefoxDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver LaunchUrlinIE(String Url) {
		WebDriver driver = new InternetExplorerDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		return driver;
	}


}