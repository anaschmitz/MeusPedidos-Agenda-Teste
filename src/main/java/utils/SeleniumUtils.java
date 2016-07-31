package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Predicate;

public class SeleniumUtils {

	public static void waitForDocumentReady(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(new Predicate<WebDriver>() {

			public boolean apply(WebDriver driver) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				Boolean result = (Boolean) jsExecutor.executeScript("return document.readyState === 'complete';");
				if (result == null) {
					result = false;
				}
				return result;
			}
		});
	}

}
