package movies.automate.details.util;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;

public class LaunchBrowser {
	
	public static WebDriver getDriver(@Optional("chrome") String browserType,String url) {
		WebDriver driver = null;
		if(browserType.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
		}
		else {
			Assert.assertTrue(false,"No browser type sent");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		Reporter.log("Navigated to browser:"+ browserType + "URL" + url, true);
		//give title assertion browser title
		return driver;
	}

	

}
