package make.my.trip.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public final class CommonUtility {
	
	public static void clickToElement(final WebElement element, final WebDriver driver) {
		new Actions(driver).moveToElement(element).click().build().perform();
	}

	public static void moveToParticularElement(final WebElement element, final WebDriver driver) {
		new Actions(driver).moveToElement(element).perform();
	}
}
