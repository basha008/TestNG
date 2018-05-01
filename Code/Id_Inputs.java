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

public class Id_Inputs {

	static Random random = new Random();

	public static String normalDropdown_RandomValue_Selection(WebDriver driver, String id) {
		Select dropdownvalues = new Select(driver.findElement(By.id(id)));
		int randomindex = (new Random().nextInt(dropdownvalues.getOptions().size() - 1)) + 1;
		dropdownvalues.selectByIndex(randomindex);
		return dropdownvalues.getFirstSelectedOption().getText();
	}

	public static String searchableDropdown_RandomValue_Selection(WebDriver driver, String containerid,
			String resultid) {
		driver.findElement(By.id(containerid)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.id(resultid)).findElements(By.tagName("li"));
		int randomindex = (new Random().nextInt(dropdownvalues.size() - 1)) + 1;
		dropdownvalues.get(randomindex).click();
		return dropdownvalues.get(randomindex).getText();
	}

	public static String normalDropdown_PerticularValue_Selection(WebDriver driver, String id, int index) {
		Select dropdownvalues = new Select(driver.findElement(By.id(id)));
		dropdownvalues.selectByIndex(index);
		return dropdownvalues.getFirstSelectedOption().getText();
	}

	public static String searchableDropdown_PerticularValue_Selection(WebDriver driver, String containerid,
			String resultid, int index) {
		driver.findElement(By.id(containerid)).click();
		List<WebElement> dropdownvalues = driver.findElement(By.id(resultid)).findElements(By.tagName("li"));
		dropdownvalues.get(index).click();
		return dropdownvalues.get(index).getText();
	}

	public static String sendFieldValue(WebDriver driver, String id, String value) {
		driver.findElement(By.id(id)).sendKeys(value);
		return value;
	}

	public static String sendDescriptionValue(WebDriver driver, String id, String type, int numberOFCharacters) {
		String descriptionvalue = DescriptionData.valueOf(type).getdescriptionData().substring(0,
				(numberOFCharacters) - 1);
		driver.findElement(By.id(id)).sendKeys(descriptionvalue);
		return descriptionvalue;
	}

	public static String getFieldValue(WebDriver driver, String id) {
		return driver.findElement(By.id(id)).getAttribute("value");
	}

	public static String getTagText(WebDriver driver, String id) {
		return driver.findElement(By.id(id)).getText();
	}

	public static String sendDateValue(WebDriver driver, String id, String dayType, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // current date
		switch (dayType) {
		case "PASTDATE":
			calendar.add(Calendar.DATE, -random.nextInt(days));
			driver.findElement(By.id(id)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "TODAY":
			driver.findElement(By.id(id)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		case "FUTUREDATE":
			calendar.add(Calendar.DATE, random.nextInt(days));
			driver.findElement(By.id(id)).sendKeys(new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime()));
			break;
		}
		return new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
	}

	public static String sendAmountValue(WebDriver driver, String id, int maxAmount) {
		String amount = String.valueOf(random.nextInt(maxAmount));
		driver.findElement(By.id(id)).sendKeys(amount);
		return amount;
	}

	public static void buttonClick(WebDriver driver, String id) {
		driver.findElement(By.id(id)).click();
	}

	public static void clickingMenuLevel2(WebDriver driver, String menulevel1id, String menulevel2id) {
		driver.findElement(By.id(menulevel1id)).click();
		driver.findElement(By.id(menulevel2id)).click();
	}

	public static void clickingMenuLevel3(WebDriver driver, String menulevel1id, String menulevel2id,
			String menulevel3id) {
		driver.findElement(By.id(menulevel1id)).click();
		driver.findElement(By.id(menulevel2id)).click();
		driver.findElement(By.id(menulevel3id)).click();

	}

	public static void clickingMenuLevel4(WebDriver driver, String menulevel1id, String menulevel2id,
			String menulevel3id, String menulevel4id) {
		driver.findElement(By.id(menulevel1id)).click();
		driver.findElement(By.id(menulevel2id)).click();
		driver.findElement(By.id(menulevel3id)).click();
		driver.findElement(By.id(menulevel4id)).click();
	}

	public static void clickingLinkAfterClosingModalPopup(WebDriver driver, String id) {
		WebElement element = driver.findElement(By.id(id));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
	}

	public static WebElement focusonElement(WebDriver driver, String ElementId) {
		WebElement focusableArea = driver.findElement(By.id(ElementId));
		new Actions(driver).moveToElement(focusableArea).perform();
		return focusableArea;
	}

	public static String sendValueinfocusedTable(WebElement focusedAreaName, String fieldId, String fieldValue) {
		focusedAreaName.findElement(By.id(fieldId)).sendKeys(fieldValue);
		return fieldValue;
	}

}
