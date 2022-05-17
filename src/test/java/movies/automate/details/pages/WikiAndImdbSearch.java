package movies.automate.details.pages;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import cucumber.runtime.Timeout;
import movies.automate.details.util.SwitchWindowTabs;
import movies.testxmls.SearchForMovieDetails;


public class WikiAndImdbSearch  implements SearchForMovieDetails{
	WebDriver driver; //declaring webdriver
	public String countryOfOriginimdbText;
	public String countryOfOriginWikiText;
	private String releaseDatetextwithCountry;
	private String releasedateImdb;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	SwitchWindowTabs switchTabsObject = new SwitchWindowTabs();
	 public WikiAndImdbSearch(WebDriver driver) {
	    	this.driver = driver;
		}
	 //webelements
	 @FindBy(xpath = ("//input[@id='searchInput']"))
	    private WebElement wikiPediaSearch;
	
	 @FindBy(xpath = ("//table[@class='infobox vevent']/tbody/tr[12]/td"))
	    private WebElement releaseDate;
	 
	 @FindBy(xpath = ("//table[@class='infobox vevent']/tbody/tr[14]/td"))
	    private WebElement countryOfOrigin;
	
	 @FindBy(xpath = ("//input[@id='searchButton' and @type='submit']"))
	    private WebElement buttonSearch;
	 
	 @FindBy(xpath = ("//div[@id='suggestion-search-container']//input[@type='text']"))
	    private WebElement imdbSearchBox; //no one should be able to access web elements using class obj
	 
	    @FindBy(xpath = ("//a[@id='home_img_holder']"))
	    private WebElement tabIcon;
	    
	    @FindBy(xpath = ("//a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat']"))
	    private WebElement releaseDateLink;
	    
	    @FindBy(xpath = ("(//tr[@class='ipl-zebra-list__item release-date-item'])[6]/td[2]"))
	    private WebElement releaseDateTable;
	    
	    @FindBy(xpath = ("//li[@data-testid='title-details-origin']//div[@class='ipc-metadata-list-item__content-container']"))
	    private WebElement countryOForiginImdb;
	    
	    @FindBy(xpath = ("//li[@role='option' and @id='react-autowhatever-1--item-0']"))
	    private WebElement dropdownFirstOption;
	 //methods
		@Override
		public void searchMovieDetailsInWikipedia(String arg) throws InterruptedException {
			switchTabsObject.switchTabs();
			wikiPediaSearch.sendKeys(arg);
	    	Thread.sleep(1000);
	    	buttonSearch.click();
	    	Thread.sleep(2000);
	    	WebElement dropdownFirstOption = driver.findElement(By.xpath("(//div[@class='suggestions']//div[@class='suggestions-results']//a)[1]"));
	    	Thread.sleep(1000);
	    	dropdownFirstOption.click();
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDate);
	    	setReleaseDatetextwithCountry(releaseDate.getText());
	    	countryOfOriginWikiText = countryOfOrigin.getText();
	    	Reporter.log("releaseDatetextwithCountry: "+ getReleaseDatetextwithCountry(),true);
	    	Reporter.log("countryOfOriginText: "+ countryOfOriginWikiText,true);
	    	//return releaseDatetextwithCountry + "-" + countryOfOriginText;
	    }
		@Override
		public void searchMovieDetailsInIMDBDetails(String arg) throws InterruptedException {
			switchTabsObject.switchTabs();
	    	imdbSearchBox.sendKeys(arg);
	    	Reporter.log("movie entered in search box:"+ arg, true);
	    	Thread.sleep(2000);
	    	try {
	    		WebDriverWait wait = new WebDriverWait(driver, 1000);
	       	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@role='option' and @id='react-autowhatever-1--item-0']")));
	       	dropdownFirstOption.click();
	    	}catch(NoSuchElementException e) {
	       		System.out.println("exception occured");
	       	}
	    	Thread.sleep(1000);
	    	driver.navigate().refresh();
	    	Thread.sleep(1000);
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDateLink);
	    	//js.executeScript("window.scrollBy(0,5750)","");
	    	countryOfOriginimdbText = countryOForiginImdb.getText();
	    	Reporter.log("Country of Origin: "+ countryOfOriginimdbText,true);
	    	Thread.sleep(3000);
	    	releaseDateLink.click();
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDateTable);
	    	setReleasedateImdb(releaseDateTable.getText());
	    	Reporter.log("releasedate: "+ getReleasedateImdb(),true);
	    	//return releasedateImdb + "-" + countryOfOriginimdbText;
	    }
		public String getReleaseDatetextwithCountry() {
			return releaseDatetextwithCountry;
		}
		public void setReleaseDatetextwithCountry(String releaseDatetextwithCountry) {
			this.releaseDatetextwithCountry = releaseDatetextwithCountry;
		}
		public String getReleasedateImdb() {
			return releasedateImdb;
		}
		public void setReleasedateImdb(String releasedateImdb) {
			this.releasedateImdb = releasedateImdb;
		}



	



		
		


	
	/*
	 * //business method public void searchForMovieDetails(String website,String
	 * arg) throws InterruptedException { if(website.equalsIgnoreCase("imdb")) {
	 * enterTextSearchBoxIMDB(arg); } else enterTextSearchBoxWikipedia(arg); String
	 * movieTitle = driver.getTitle(); System.out.println("movie title: "+
	 * movieTitle);
	 * Assert.assertTrue(movieTitle.toLowerCase().contains(arg.toLowerCase())); }
	 */
	    
	   

}
