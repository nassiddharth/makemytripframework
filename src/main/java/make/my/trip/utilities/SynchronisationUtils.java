package make.my.trip.utilities;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;

public final class SynchronisationUtils {

	public static void staticWait(final long seconds) {
		Uninterruptibles.sleepUninterruptibly(seconds, TimeUnit.SECONDS);
	}

	public static void waitForElementToBeClickable(final WebElement element, final WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementToBeVisible(final WebElement element, final WebDriver driver) {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
	}
}
