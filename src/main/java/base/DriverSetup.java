package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSetup {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigLoader.get("browser").toLowerCase();

			switch (browser) {
			case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--disable-blink-features=AutomationControlled");
				driver = new ChromeDriver(options);
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;

			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			default:
				throw new RuntimeException("Invalid browser: " + browser);
			}

			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
