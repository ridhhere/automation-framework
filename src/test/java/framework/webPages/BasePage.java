package framework.webPages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import stepdefinition.SharedSD;

import java.sql.Driver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mohammadmuntakim
 */
public class BasePage {

	public static WebElement webAction(final By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(SharedSD.getDriver())
				.withTimeout(Duration.ofSeconds(3))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 15 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}

	public void clickOn(By locator) {
		webAction(locator).click();
	}

	public WebElement getWebElement(By locator){
		return webAction(locator).findElement(locator);
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}


	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement element = webAction(locator);
		Select selectElement = new Select(element);
		selectElement.selectByVisibleText(dropdownText);
	}

	public String getTextFromSelectedDropDown(By locator){
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		return selectMonth.getFirstSelectedOption().getText();
	}

	public boolean isDropDownHasDuplicates(By locator){
		List<WebElement> monthsList = webAction(locator).findElements(locator);
		HashSet<String> monthsListDuplicate = new HashSet<>();
		ArrayList<String> duplicateValue = new ArrayList<>();
		Boolean result = false;
		for (WebElement month : monthsList) {
			if (monthsListDuplicate.add(month.getText()) == false){
				duplicateValue.add(month.getText());
				result = true;
			} else{
				monthsListDuplicate.add(month.getText());
				result = false;
			}
		}
		return result;

	}

	public void scrollByPixel(int value) throws InterruptedException {
		JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();
		jsScrollBy.executeScript("scrollBy(0,"+value+");"); //"scrollBy(0,1200);"
		Thread.sleep(1000);

	}

	public void scrollToElement(By locator)  {
		JavascriptExecutor jsScrollBy = (JavascriptExecutor) SharedSD.getDriver();
		jsScrollBy.executeScript("arguments[0].scrollIntoView();", webAction(locator));
	}

	public void scrollSlowlyToElement(By locator)  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		Actions dragger = new Actions(SharedSD.getDriver());
		WebElement draggablePartOfScrollbar = webAction(locator);

		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 60;
		for (int i=10;i<500;i=i+numberOfPixelsToDragTheScrollbarDown){
			try{
				// this causes a gradual drag of the scroll bar, 10 units at a time
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
				try {
					Thread.sleep(5000L);
				} catch (InterruptedException e) {
				}
			}catch(Exception e1){}

		}

		// now drag opposite way (downwards)
		numberOfPixelsToDragTheScrollbarDown = -50;
		for (int i=500;i>10;i=i+numberOfPixelsToDragTheScrollbarDown){
			// this causes a gradual drag of the scroll bar, -10 units at a time
			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScrollbarDown).release().perform();
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
			}
		}
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public Integer getIntFromElement(By locator){
		return Integer.parseInt(webAction(locator).getText());
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement month = webAction(locator);
		Select selectMonth = new Select(month);
		//select element by index
		selectMonth.selectByIndex(index);
	}

	public void hitEnterByLocator(By locator){
		webAction(locator).sendKeys(Keys.RETURN);
	}


	public boolean isEnabled(By locator){
		return webAction(locator).isEnabled();
	}

	public void selectByText(By locator, String value){
		WebElement selectText = webAction(locator).findElement(locator);
		Select text = new Select(selectText);
		text.selectByVisibleText(value);
	}

	public void selectByIndex(By locator,int value){
		WebElement selectIndex = webAction(locator).findElement(locator);
		Select index = new Select(selectIndex);
		index.selectByIndex(value);
	}

	public void selectByValue(By locator,String value){
		WebElement selectValue = webAction(locator).findElement(locator);
		Select byValue = new Select(selectValue);
		byValue.selectByValue(value);
	}

	public boolean isDropDownContainsValue(By locator,String value) {
		List<WebElement> dropDown = (List<WebElement>) webAction(locator).findElement(locator);
		return dropDown.contains(value);
	}

	public WebElement getWebElementsByLocator(By locator){
		List<WebElement> webElements = webAction(locator).findElements(locator);
		return (WebElement) webElements;
	}



}
