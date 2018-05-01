package resources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Class_Inputs {

	static Random random = new Random();

	public static String normalDropdown_RandomValue_Selection(WebDriver driver, String className) {
		Select dropdownvalues = new Select(driver.findElement(By.className(className)));
		int randomindex = (new Random().nextInt(dropdownvalues.getOptions().size() - 1)) + 1;
		dropdownvalues.selectByIndex(randomindex);
		return dropdownvalues.getFirstSelectedOption().getText();
	}

	public static String searchableDropdown_RandomValue_Selection(WebDriver driver, String containerclassName,
			String resultclassName) {
		driver.findElement(By.className(containerclassName)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.className(resultclassName))
				.findElements(By.tagName("li"));
		int randomindex = (new Random().nextInt(dropdownvalues.size() - 1)) + 1;
		dropdownvalues.get(randomindex).click();
		return dropdownvalues.get(randomindex).getText();
	}

	public static String normalDropdown_PerticularValue_Selection(WebDriver driver, String className, int index) {
		Select dropdownvalues = new Select(driver.findElement(By.className(className)));
		dropdownvalues.selectByIndex(index);
		return dropdownvalues.getFirstSelectedOption().getText();
	}

	public static String searchableDropdown_PerticularValue_Selection(WebDriver driver, String containerclassName,
			String resultclassName, int index) {
		driver.findElement(By.className(containerclassName)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.className(resultclassName))
				.findElements(By.tagName("li"));
		dropdownvalues.get(index).click();
		return dropdownvalues.get(index).getText();
	}

	public static String sendFieldValue(WebDriver driver, String className, String value) {
		driver.findElement(By.className(className)).sendKeys(value);
		return value;
	}

	public static String sendDescriptionValue(WebDriver driver, String className, String type, int numberOFCharacters) {
		String descriptionvalue = DescriptionData.valueOf(type).getdescriptionData().substring(0,
				(numberOFCharacters) - 1);
		driver.findElement(By.className(className)).sendKeys(descriptionvalue);
		return descriptionvalue;
	}

	public static String getFieldValue(WebDriver driver, String className) {
		return driver.findElement(By.className(className)).getAttribute("value");
	}

	public static String getTagText(WebDriver driver, String className) {
		return driver.findElement(By.className(className)).getText();
	}

	public static String sendDateValue(WebDriver driver, String className, String dayType, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // current date
		switch (dayType) {
		case "PASTDATE":
			calendar.add(Calendar.DATE, -random.nextInt(days));
			driver.findElement(By.className(className))
					.sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "TODAY":
			driver.findElement(By.className(className))
					.sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "FUTUREDATE":
			calendar.add(Calendar.DATE, random.nextInt(days));
			driver.findElement(By.className(className))
					.sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		}
		return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
	}

	public static String sendAmountValue(WebDriver driver, String className, int maxAmount) {
		String amount = String.valueOf(random.nextInt(maxAmount));
		driver.findElement(By.className(className)).sendKeys(amount);
		return amount;
	}

	public static void buttonClick(WebDriver driver, String className) {
		driver.findElement(By.className(className)).click();
	}

	public static void clickingMenuLevel2(WebDriver driver, String menulevel1className, String menulevel2className) {
		driver.findElement(By.className(menulevel1className)).click();
		driver.findElement(By.className(menulevel2className)).click();
	}

	public static void clickingMenuLevel3(WebDriver driver, String menulevel1className, String menulevel2className,
			String menulevel3className) {
		driver.findElement(By.className(menulevel1className)).click();
		driver.findElement(By.className(menulevel2className)).click();
		driver.findElement(By.className(menulevel3className)).click();

	}

	public static void clickingMenuLevel4(WebDriver driver, String menulevel1className, String menulevel2className,
			String menulevel3className, String menulevel4className) {
		driver.findElement(By.className(menulevel1className)).click();
		driver.findElement(By.className(menulevel2className)).click();
		driver.findElement(By.className(menulevel3className)).click();
		driver.findElement(By.className(menulevel4className)).click();
	}

	public static void clickingLinkAfterClosingModalPopup(WebDriver driver, String className) {
		WebElement element = driver.findElement(By.className(className));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public static WebElement focusonElement(WebDriver driver, String ElementclassName) {
		WebElement focusableArea = driver.findElement(By.className(ElementclassName));
		new Actions(driver).moveToElement(focusableArea).perform();
		return focusableArea;
	}

	public static String sendValueinfocusedTable(WebElement focusedAreaName, String fieldclassName, String fieldValue) {
		focusedAreaName.findElement(By.className(fieldclassName)).sendKeys(fieldValue);
		return fieldValue;
	}
}
