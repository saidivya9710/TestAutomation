package movies.automate.details.testcases;

//import java.util.concurrent.TimeUnit; -->unused imports


//import org.openqa.selenium.By; -->unused imports
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver; -->unused imports
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import movies.automate.details.pages.WikiSearch;
import movies.automate.details.util.LaunchBrowser;

public class Do_SmokeTest {
	WebDriver driver;
	static String[] imdbDetails;
	WikiSearch wikiSearchObject = new WikiSearch(driver);
	@Test(priority = 0)	
	@Parameters({"browserType","url"})
	public static void movie_deatils_search(String browserType, String url) throws InterruptedException {
		WebDriver driver = LaunchBrowser.getDriver(browserType,url);
		WikiSearch wikiSearchObject = PageFactory.initElements(driver,WikiSearch.class);
		
		imdbDetails = wikiSearchObject.enterTextSearchBoxIMDB("pushpa").split("-");
		
		/*
		 * WebDriver driver = new ChromeDriver();
		 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 * driver.manage().window().maximize();
		 */
		//String url = "https://www.wikipedia.org";

		
		//driver.get(url);
		
		/*
		 * driver.findElement(By.xpath("//input[@id='searchInput']")).sendKeys("pushpa")
		 * ;
		 * 
		 * driver.findElement(By.className("pure-button pure-button-primary-progressive"
		 * )).click();
		 */
		 	
	
	
	}
}
