package movies.automate.details.pages;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import movies.automate.details.testcases.BaseTestNG;

public class ValidationsPage {
	WebDriver driver;
	 public ValidationsPage(WebDriver driver) {
	    	this.driver = driver;
		}
	
	 WikiAndImdbSearch imdbSearchObject = new WikiAndImdbSearch(driver);

	 //business method
    public void searchForMovieDetails(String website,String arg) throws InterruptedException {
    		
    	String movieTitle = driver.getTitle();
    	System.out.println("movie title: "+ movieTitle);
    	Assert.assertTrue(movieTitle.toLowerCase().contains(arg.toLowerCase()));
    	
    }
   
}
