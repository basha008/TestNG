package resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkText_Inputs {

	public static void tabnavigation(WebDriver driver, String linkText) {
		driver.findElement(By.linkText(linkText)).click();;
	}

}
