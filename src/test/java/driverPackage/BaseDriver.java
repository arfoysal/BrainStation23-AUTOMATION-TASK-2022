package driverPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {

	WebDriver driver = null;

	@BeforeSuite
	public void setUp() {

		String browser = System.getProperty("browser", "chrome");
		if (browser.contains("opera")) {
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();

		} else if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get("https://www.udemy.com");
		driver.manage().window().maximize();

		PageDriver.getInstance().setDriver(driver);
	}

	@AfterSuite
	public void tearDown() {
		PageDriver.getCurrentDriver().quit();

	}

}
