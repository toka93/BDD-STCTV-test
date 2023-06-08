package taskPages;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public void openCountryList(WebDriver driver) {
		WebElement countriesButton = webEl(driver, By::id, "country-btn");
		countriesButton.click();

	}

	public void chooseDifferentCountry(WebDriver driver, String country) {
		WebElement countryButton = webEl(driver, By::id, country);
		countryButton.click();

	}

	public void checkPackagesTypes(WebDriver driver, List<String> expectedPackages) {

		List<WebElement> userpackages = webEls(driver, By::xpath, "//*[@class='plan-title']");
		List<String> packagesValues = userpackages.stream().map(i -> i.getText()).collect(Collectors.toList());
		packagesValues.forEach(item -> System.out.println(item));
		Set<String> actual = packagesValues.stream().collect(Collectors.toSet());
		Set<String> expected = expectedPackages.stream().collect(Collectors.toSet());

		assertTrue(actual.equals(expected));

	}

	public void chooseEnglishLang(WebDriver driver) {
		WebElement translationButton = webEl(driver, By::id, "translation-btn");
		String cuurentUrl = driver.getCurrentUrl();
		if (cuurentUrl.contains("-ar"))
			translationButton.click();

	}

	public void checkPriceAndCurrencyforEachPackage(WebDriver driver, String packageType, String priceValue) {
		priceValue = priceValue.replace("\"", "");
		WebElement price = webEl(driver, By::xpath, "//*[contains(@id,'" + packageType + "') and @class='price']/b");
		String priceActual = price.getText();
		WebElement currency = webEl(driver, By::xpath, "//*[contains(@id,'" + packageType + "') and @class='price']/i");
		String value = currency.getText();
		String currencyv = StringUtils.substringBefore(value, "/");
		assertTrue(priceActual.equals(priceValue));
		assertTrue(currencyv.equals("USD"));

	}

}
