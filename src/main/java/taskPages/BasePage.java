package taskPages;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement webEl(WebDriver driver, Function<String, By> locatorStrategy, String locator) {
		return driver.findElement(locatorStrategy.apply(locator));
	}

	public List<WebElement> webEls(WebDriver driver, Function<String, By> locatorStrategy, String locator) {
		return driver.findElements(locatorStrategy.apply(locator));
	}

}
