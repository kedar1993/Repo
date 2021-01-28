package UserDefinedLibraries;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {

	public static WebDriver driver;
	public static String exepath;
	public static String url = "https://www.google.com/";
	public static String browsertype;

	// INSTANTIATION OF CHROME AND MOZILA FIREFOX BROWSERS WITH THE HELP OF CORRESPONDING DRIVERS
	
	public static WebDriver driverInstantiate(String browser) {
		browsertype = browser;
		if (browsertype.equalsIgnoreCase("chrome")) {
			exepath = "W:\\Source\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exepath);
			driver = new ChromeDriver();
		}
		else if (browsertype.equalsIgnoreCase("firefox")) {
			exepath = "W:\\Source\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", exepath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().deleteAllCookies();
		return driver;
	}

	// CLOSING THE DRIVERS
	
	public static void driverClose() {
		DriverSetup.driver.close();
	}
}