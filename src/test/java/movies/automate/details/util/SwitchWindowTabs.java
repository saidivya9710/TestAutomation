package movies.automate.details.util;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

public class SwitchWindowTabs {
	public void switchTabs () throws InterruptedException {
		WebDriver driver = null;
		Thread.sleep(2000);
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));
		driver.close();
		driver.switchTo().window(tabs2.get(1)); 
	   	Thread.sleep(2000);

	}
	
}
