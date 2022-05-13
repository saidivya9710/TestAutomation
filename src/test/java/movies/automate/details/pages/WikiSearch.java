package movies.automate.details.pages;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

public class WikiSearch {
	 WebDriver driver; //declaring webdriver
	 public WikiSearch(WebDriver driver) {
	    	this.driver = driver;
		}
	
	 //webelements
	    @FindBy(xpath = ("//div[@id='suggestion-search-container']//input[@type='text']"))
	    private WebElement wikiSearchBox; //no one should be able to access web elements using class obj
	    @FindBy(xpath = ("//a[@id='home_img_holder']"))
	    private WebElement tabIcon;
	    @FindBy(xpath = ("//a[@href='/title/tt9389998/releaseinfo?ref_=tt_dt_rdat']"))
	    private WebElement releaseDateLink;
	    @FindBy(xpath = ("(//tr[@class='ipl-zebra-list__item release-date-item'])[6]/td[2]"))
	    private WebElement releaseDateTable;
	    @FindBy(xpath = ("//li[@data-testid='title-details-origin']//div[@class='ipc-metadata-list-item__content-container']"))
	    private WebElement countryOForiginImdb;
	   
	   
	    
	    //methods
	       public String enterTextSearchBoxIMDB(String arg) throws InterruptedException {
	    	   Thread.sleep(20000);   
	    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	driver.switchTo().window(tabs2.get(0));
	    	driver.close();
	    	driver.switchTo().window(tabs2.get(1));
	    	Thread.sleep(2000);
	    	wikiSearchBox.sendKeys(arg);
	    	Reporter.log("movie entered in search box:"+ arg, true);
	    	Thread.sleep(2000);
	    	//List<WebElement> dropdown = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']"));
	       	WebElement dropdownFirstOption = driver.findElement(By.xpath("//li[@role='option' and @id='react-autowhatever-1--item-0']"));
	       	Thread.sleep(3000);
	       	dropdownFirstOption.click();
	    	Thread.sleep(1000);
	    	driver.navigate().refresh();
	    	Thread.sleep(1000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDateLink);
	    	//js.executeScript("window.scrollBy(0,5750)","");
	    	String countryOfOriginimdbText = countryOForiginImdb.getText();
	    	Reporter.log("Country of Origin: "+ countryOfOriginimdbText,true);
	    	Thread.sleep(3000);
	    	releaseDateLink.click();
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDateTable);
	    	String releasedateImdb = releaseDateTable.getText();
	    	Reporter.log("releasedate: "+ releasedateImdb,true);
	    	return releasedateImdb + "-" + countryOfOriginimdbText;
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
