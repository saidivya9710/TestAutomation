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


public class ImdbSearch {
	WebDriver driver; //declaring webdriver
	 public ImdbSearch(WebDriver driver) {
	    	this.driver = driver;
		}
	 //webelements
	 @FindBy(xpath = ("//input[@id='searchInput']"))
	    private WebElement wikiPediaSearch;
	
	 @FindBy(xpath = ("//table[@class='infobox vevent']/tbody/tr[12]/td"))
	    private WebElement releaseDate;
	 
	 @FindBy(xpath = ("//table[@class='infobox vevent']/tbody/tr[14]/td"))
	    private WebElement countryOfOrigin;
	 //methods
	 public String enterTextSearchBoxWikipedia(String arg) throws InterruptedException {
		 Thread.sleep(2000);
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    	driver.switchTo().window(tabs2.get(0));
	    	driver.close();
	    	driver.switchTo().window(tabs2.get(1));
	    	Thread.sleep(2000);
	    	wikiPediaSearch.sendKeys("pushpa");
	    	//wikiPediaSearch.sendKeys(Keys.ENTER);
	    	Thread.sleep(2000);
	    	WebElement dropdownFirstOption = driver.findElement(By.xpath("(//div[@class='suggestions']//div[@class='suggestions-results']//a)[1]"));
	    	Thread.sleep(1000);
	    	dropdownFirstOption.click();
	    	Thread.sleep(1000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].scrollIntoView()", releaseDate);
	    	String releaseDatetextwithCountry = releaseDate.getText().split(" (")[0];
	    	String countryOfOriginText = countryOfOrigin.getText();
	    	Reporter.log("releaseDatetextwithCountry: "+ releaseDatetextwithCountry,true);
	    	Reporter.log("countryOfOriginText: "+ countryOfOriginText,true);
	    	return releaseDatetextwithCountry + "-" + countryOfOriginText;
	    }
}
