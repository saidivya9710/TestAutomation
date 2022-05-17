package movies.testxmls;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import movies.automate.details.pages.WikiAndImdbSearch;

public class GenerateExtentReports {
	private static WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		
		//create extent reports and attach reporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@Test
	public void test1() throws IOException, InterruptedException {
		WikiAndImdbSearch movieDetailsSearchObject = PageFactory.initElements(driver,WikiAndImdbSearch.class);
		movieDetailsSearchObject.searchMovieDetailsInIMDBDetails("pushpa");
		movieDetailsSearchObject.searchMovieDetailsInWikipedia("pushpa");		
		//add all events under test create toggle for test
		ExtentTest test1 = extent.createTest("movie details search", "this is to verify movie details displayed in different websites");
		test1.log(Status.INFO,"Starting testcase");
		test1.info("Test complted");
		test1.fail("details");
		test1.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterSuite
	public void tearDown() {
		extent.flush();
	}
	
	
	
	


}
