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

public class Xpath_Inputs {

	static Random random = new Random();

	public static String normalDropdown_RandomValue_Selection(WebDriver driver, String xpath) {
		Select dropdownvalues = new Select(driver.findElement(By.xpath(xpath)));
		int randomindex = (new Random().nextInt(dropdownvalues.getOptions().size() - 1)) + 1;
		dropdownvalues.selectByIndex(randomindex);
		return dropdownvalues.getFirstSelectedOption().getText();

	}

	public static String searchableDropdown_RandomValue_Selection(WebDriver driver, String containerxpath,
			String resultxpath) {
		driver.findElement(By.xpath(containerxpath)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.xpath(resultxpath)).findElements(By.tagName("li"));
		int randomindex = (new Random().nextInt(dropdownvalues.size() - 1)) + 1;
		dropdownvalues.get(randomindex).click();
		return dropdownvalues.get(randomindex).getText();
	}

	public static String normalDropdown_PerticularValue_Selection(WebDriver driver, String xpath, int index) {
		Select dropdownvalues = new Select(driver.findElement(By.xpath(xpath)));
		dropdownvalues.selectByIndex(index);
		return dropdownvalues.getFirstSelectedOption().getText();
	}

	public static String searchableDropdown_PerticularValue_Selection(WebDriver driver, String containerxpath,
			String resultxpath, int index) {
		driver.findElement(By.xpath(containerxpath)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.xpath(resultxpath)).findElements(By.tagName("li"));
		dropdownvalues.get(index).click();
		return dropdownvalues.get(index).getText();
	}

	public static String sendFieldValue(WebDriver driver, String xpath, String value) {
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		return value;
	}

	public static String sendDescriptionValue(WebDriver driver, String xpath, String type, int numberOFCharacters) {
		String descriptionvalue = DescriptionData.valueOf(type).getdescriptionData().substring(0,
				(numberOFCharacters) - 1);
		driver.findElement(By.xpath(xpath)).sendKeys(descriptionvalue);
		return descriptionvalue;
	}

	public static String getFieldValue(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).getAttribute("value");
	}

	public static String getTagText(WebDriver driver, String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
	}

	public static String sendDateValue(WebDriver driver, String xpath, String dayType, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // current date
		switch (dayType) {
		case "PASTDATE":
			calendar.add(Calendar.DATE, -random.nextInt(days));
			driver.findElement(By.xpath(xpath)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "TODAY":
			driver.findElement(By.xpath(xpath)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "FUTUREDATE":
			calendar.add(Calendar.DATE, random.nextInt(days));
			driver.findElement(By.xpath(xpath)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		}
		return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
	}

	public static String sendAmountValue(WebDriver driver, String xpath, int maxAmount) {
		String amount = String.valueOf(random.nextInt(maxAmount));
		driver.findElement(By.xpath(xpath)).sendKeys(amount);
		return amount;
	}

	public static void buttonClick(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public static void clickingMenuLevel2(WebDriver driver, String menulevel1xpath, String menulevel2xpath) {
		driver.findElement(By.xpath(menulevel1xpath)).click();
		driver.findElement(By.xpath(menulevel2xpath)).click();
	}

	public static void clickingMenuLevel3(WebDriver driver, String menulevel1xpath, String menulevel2xpath,
			String menulevel3xpath) {
		driver.findElement(By.xpath(menulevel1xpath)).click();
		driver.findElement(By.xpath(menulevel2xpath)).click();
		driver.findElement(By.xpath(menulevel3xpath)).click();

	}

	public static void clickingMenuLevel4(WebDriver driver, String menulevel1xpath, String menulevel2xpath,
			String menulevel3xpath, String menulevel4xpath) {
		driver.findElement(By.xpath(menulevel1xpath)).click();
		driver.findElement(By.xpath(menulevel2xpath)).click();
		driver.findElement(By.xpath(menulevel3xpath)).click();
		driver.findElement(By.xpath(menulevel4xpath)).click();
	}

	public static void clickingLinkAfterClosingModalPopup(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public static WebElement focusonElement(WebDriver driver, String Elementxpath) {
		WebElement focusableArea = driver.findElement(By.xpath(Elementxpath));
		new Actions(driver).moveToElement(focusableArea).perform();
		return focusableArea;
	}

	public static String sendValueinfocusedTable(WebElement focusedAreaName, String fieldxpath, String fieldValue) {
		focusedAreaName.findElement(By.xpath(fieldxpath)).sendKeys(fieldValue);
		return fieldValue;
	}
}
