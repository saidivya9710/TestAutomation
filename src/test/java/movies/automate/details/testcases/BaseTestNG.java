package movies.automate.details.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;

import movies.automate.details.pages.WikiAndImdbSearch;
import movies.automate.details.util.LaunchBrowser;

public class BaseTestNG {

	WebDriver driver;
	WikiAndImdbSearch movieDetailsSearchObject = new WikiAndImdbSearch(driver);
	
	@Test(priority = 0)	
	@Parameters({"browserType","url"})
	public void movie_deatils_search_validation() throws InterruptedException {
		//WebDriver driver = LaunchBrowser.getDriver(browserType,url);
		WikiAndImdbSearch movieDetailsSearchObject = PageFactory.initElements(driver,WikiAndImdbSearch.class);
		movieDetailsSearchObject.searchMovieDetailsInIMDBDetails("pushpa");
		movieDetailsSearchObject.searchMovieDetailsInWikipedia("pushpa");
		String countryOfOriginimdbText= movieDetailsSearchObject.countryOfOriginimdbText;
		String countryOfOriginWikiText= movieDetailsSearchObject.countryOfOriginWikiText;
		String releaseDatetextwithCountry= movieDetailsSearchObject.getReleaseDatetextwithCountry();
		String releasedateImdb = movieDetailsSearchObject.getReleasedateImdb();
		Assert.assertEquals(countryOfOriginimdbText,countryOfOriginWikiText );
		Assert.assertTrue(releaseDatetextwithCountry.contains(releasedateImdb));
	}
}
