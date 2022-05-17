package movies.automate.details.util;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {
	
	static WebDriver driver;
	@BeforeMethod
	public static WebDriver getDriver(@Optional("chrome") String browserType,String url) {
		
		if(browserType.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("firefox")) {
			// driver = new FirefoxDriver();
			//version 5.1.1 released in april
			WebDriver driver = WebDriverManager.firefoxdriver().create();
			//driver.get(url);
			
		}
		else {
			Assert.assertTrue(false,"No browser type sent");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(url);
		Reporter.log("Navigated to browser:"+ browserType + "URL" + url, true);
		//give title assertion browser title
		return driver;
	}
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	

}
