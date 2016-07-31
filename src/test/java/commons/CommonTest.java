package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonTest {

	protected WebDriver driver;

	@BeforeSuite
	public void initDriver() throws Exception {
		System.out.println("You are testing in firefox");
		driver = new FirefoxDriver();
	}

	@AfterSuite
	public void quitDriver() throws Exception {
		driver.quit();
		System.out.println("Quit driver!");
	}
}
