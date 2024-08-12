package baseClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import configuration.Configuration;
import utilityClasses.Utility;

public class BaseClass {
	
//	public void launchBrowser() {
//		System.setProperty("webdriver.chrome.driver", Configuration.buildpath);
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get(Configuration.urlTandable);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
//	}
	
	WebDriver driver;
	public WebDriver initializeBrowser() throws IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver",
				Configuration.buildpath);
	    driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		
		driver.get(Utility.readPropertyFileData("URL"));
		System.out.println("-----------Reading property file 11------");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15000));
		return driver;
	}
	
	public void implictiWait(int wait) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
	}

	
	
}
