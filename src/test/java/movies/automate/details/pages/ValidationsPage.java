package movies.automate.details.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import movies.automate.details.testcases.Do_SmokeTest;
import movies.automate.details.testcases.Do_SmokeTestForWiki;

public class ValidationsPage {
	WebDriver driver;
	 public ValidationsPage(WebDriver driver) {
	    	this.driver = driver;
		}
	 Do_SmokeTest wikiSearchValidationObject = new Do_SmokeTest();
	 Do_SmokeTestForWiki imdbSearchValidationObject = new Do_SmokeTestForWiki();
	 ImdbSearch imdbSearchObject = new ImdbSearch(driver);

	 //business method
    public void searchForMovieDetails(String website,String arg) throws InterruptedException {
    		
    	String movieTitle = driver.getTitle();
    	System.out.println("movie title: "+ movieTitle);
    	Assert.assertTrue(movieTitle.toLowerCase().contains(arg.toLowerCase()));
    	
    }
   
}
