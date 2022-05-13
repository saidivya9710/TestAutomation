package movies.automate.details.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import movies.automate.details.pages.ImdbSearch;
import movies.automate.details.util.LaunchBrowser;

public class Do_SmokeTestForWiki {

	WebDriver driver;
	ImdbSearch imdbSearchObject = new ImdbSearch(driver);
	 Do_SmokeTest wikiSearchValidationObject = new Do_SmokeTest();
	@Test(priority = 1)	
	@Parameters({"browserType","url"})
	public void movie_deatils_search(String browserType, String url) throws InterruptedException {
		WebDriver driver = LaunchBrowser.getDriver(browserType,url);
		ImdbSearch imdbSearchObject = PageFactory.initElements(driver,ImdbSearch.class);
		String[] wikiDetails = imdbSearchObject.enterTextSearchBoxWikipedia("pushp").split("-");
		String[] imbdDetails = Do_SmokeTest.imdbDetails;
		for(String s: wikiDetails) {
			Reporter.log("moviedetails"+s,true);
		}
		for(String s: imbdDetails) {
			Reporter.log("moviedetails"+s,true);
			}
	}
}
