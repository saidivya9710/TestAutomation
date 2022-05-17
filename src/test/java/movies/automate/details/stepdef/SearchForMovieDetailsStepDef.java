package movies.automate.details.stepdef;

import movies.testxmls.SearchForMovieDetails;


import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import movies.automate.details.testcases.BaseTestNG;
import movies.automate.details.util.LaunchBrowser;
public class SearchForMovieDetailsStepDef {
	@Steps
	SearchForMovieDetails searchObject;
	@Steps
	BaseTestNG testClassObject;
	
	@Given("Open Chrome browser with imdb URL")
	public void open_chrome_browser_imdb() throws Throwable
	{
    	LaunchBrowser.getDriver("chrome","https://www.imdb.com/");
		
	}
    @And("Open Chrome browser with wiki URL")//else we can pass parameters from feature using examples keyword and || symbol
   	public void open_chrome_browser_wiki() throws Throwable
   	{
       	LaunchBrowser.getDriver("chrome","https://en.wikipedia.org/wiki/Main_Page");
   		
   	}
	 @And("Search for movie details in Wikipedia")
		public void search_for_movie_details_Wikipedia() throws Throwable
		{
		 searchObject.searchMovieDetailsInWikipedia("pushpa");
		}
	 @And("Search for movie details in IMDB")
		public void search_for_movie_details_IMDB() throws Throwable
		{
		 searchObject.searchMovieDetailsInIMDBDetails("pushpa");
		}
	@Then("Validate movie details displayed")
	public void validate_movie_details() throws Throwable
	{
		testClassObject.movie_deatils_search_validation();
	}
		
	}


	
