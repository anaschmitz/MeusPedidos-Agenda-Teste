package commons;

import java.security.InvalidParameterException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class CommonTest {

	protected WebDriver driver;

	@BeforeSuite
	@Parameters({ "browser", "url" })
	public void initDriver(@Optional("firefox") String browser, String url) throws Exception {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else  {
			throw new InvalidParameterException("Browser " + browser + "not supported!");
		}
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterSuite
	public void quitDriver() throws Exception {
		//driver.quit();
	}
}
